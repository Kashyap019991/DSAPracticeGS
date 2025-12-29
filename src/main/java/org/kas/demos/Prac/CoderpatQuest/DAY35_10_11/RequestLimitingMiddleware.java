package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/*
Q:
We have two services A and B. A service is sending out many request and B can handle only
10 request at a time design a middleware so that B can get only 10 request. java
 */
public class RequestLimitingMiddleware {

    private final Semaphore semaphore;
    private final ServiceB serviceB; // Assuming ServiceB is an interface or class

    public RequestLimitingMiddleware(ServiceB serviceB) {
        this.semaphore = new Semaphore(10); // Limit to 10 concurrent requests
        this.serviceB = serviceB;
    }

    public void processRequest(Request request) {
        try {
            // Attempt to acquire a permit, waiting if necessary
            // Consider using tryAcquire with a timeout for non-blocking behavior
            semaphore.acquire(); 
            System.out.println("Permit acquired. Processing request for Service B...");
            // Call the actual Service B method
            serviceB.handleRequest(request); 
            System.out.println("Request processed by Service B.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Request processing interrupted: " + e.getMessage());
        } finally {
            // Ensure the permit is released even if an exception occurs
            semaphore.release();
            System.out.println("Permit released.");
        }
    }
}

// Example Service B interface (replace with your actual Service B)
interface ServiceB {
    void handleRequest(Request request);
}

// Example Request class (replace with your actual Request object)
class Request {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}