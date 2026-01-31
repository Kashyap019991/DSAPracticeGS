package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private static final int BUFFER_CAPACITY = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    // Producer thread class
    static class Producer implements Runnable {
        @Override
        public void run() {
            int item = 0;
            while (true) {
                synchronized (buffer) {
                    // Wait while the buffer is full
                    while (buffer.size() == BUFFER_CAPACITY) {
                        try {
                            System.out.println("Buffer is full. Producer waiting.");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Produce an item and add it to the buffer
                    buffer.add(item);
                    System.out.println("Producer produced: " + item);
                    item++;

                    // Notify waiting consumer(s)
                    buffer.notifyAll();
                }
                // Simulate work with a delay
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Consumer thread class
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    // Wait while the buffer is empty
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer is empty. Consumer waiting.");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Consume an item from the buffer
                    Integer item = buffer.poll();
                    System.out.println("Consumer consumed: " + item);

                    // Notify waiting producer(s)
                    buffer.notifyAll();
                }
                // Simulate work with a delay
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
