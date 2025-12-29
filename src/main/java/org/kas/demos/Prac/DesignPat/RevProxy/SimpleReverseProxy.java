package org.kas.demos.Prac.DesignPat.RevProxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
Simple Socket-based Reverse Proxy Example
This example creates a simple TCP server that listens on a local port (8080)
and forwards all data to a target server (example.com:80). This demonstrates the
core concept of a reverse proxy at the socket level, but it does not fully implement
the HTTP protocol.
 */
public class SimpleReverseProxy {
    private static final int LOCAL_PORT = 8080;
    private static final String REMOTE_HOST = "example.com";
    private static final int REMOTE_PORT = 80;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(LOCAL_PORT);
        System.out.println("Proxy Server started on port " + LOCAL_PORT);
        System.out.println("Forwarding requests to " + REMOTE_HOST + ":" + REMOTE_PORT);

        while (true) {
            try {
                // Wait for a client connection
                final Socket clientSocket = serverSocket.accept();
                
                // Create a connection to the remote server
                final Socket remoteSocket = new Socket(REMOTE_HOST, REMOTE_PORT);

                // Handle the connection in a new thread
                new Thread(() -> handleConnection(clientSocket, remoteSocket)).start();

            } catch (IOException e) {
                System.err.println("Error handling client connection: " + e.getMessage());
            }
        }
    }

    private static void handleConnection(Socket clientSocket, Socket remoteSocket) {
        try {
            // Get input and output streams for both sockets
            final InputStream clientIn = clientSocket.getInputStream();
            final OutputStream clientOut = clientSocket.getOutputStream();
            final InputStream remoteIn = remoteSocket.getInputStream();
            final OutputStream remoteOut = remoteSocket.getOutputStream();

            // Create threads to pipe data in both directions
            Thread clientToRemote = new Thread(new Pipe(clientIn, remoteOut));
            Thread remoteToClient = new Thread(new Pipe(remoteIn, clientOut));
            
            clientToRemote.start();
            remoteToClient.start();

            // Wait for both threads to finish
            clientToRemote.join();
            remoteToClient.join();

        } catch (InterruptedException | IOException e) {
            System.err.println("Error during data transfer: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                remoteSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Helper class to continuously read from an InputStream and write to an OutputStream.
 */
class Pipe implements Runnable {
    private final InputStream in;
    private final OutputStream out;

    public Pipe(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[4096];
        int bytesRead;
        try {
            // Read from input and write to output until end of stream
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        } catch (IOException e) {
            // Connection closed or error occurred
        }
    }
}
