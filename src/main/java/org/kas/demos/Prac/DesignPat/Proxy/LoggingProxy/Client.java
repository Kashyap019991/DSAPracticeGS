package org.kas.demos.Prac.DesignPat.Proxy.LoggingProxy;

public class Client {
    public static void main(String[] args) {
        // Create the real service object
        RealService realService = new RealService();

        // Create the proxy, passing in the real service
        Service proxy = new ProxyService(realService);

        // The client uses the proxy to perform the operation
        proxy.performOperation("client_request_1");

        // The original RealService can still be used directly if needed
        System.out.println("\n--- Direct call to the real service ---");
        realService.performOperation("client_request_2");
    }
}
