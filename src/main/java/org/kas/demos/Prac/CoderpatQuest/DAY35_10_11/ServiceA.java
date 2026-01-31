package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11;

public class ServiceA {
    private final RequestLimitingMiddleware middleware;

    public ServiceA(RequestLimitingMiddleware middleware) {
        this.middleware = middleware;
    }

    public void sendRequestToB(Request request) {
        System.out.println("Service A sending request...");
        middleware.processRequest(request);
    }
}