package org.kas.demos.Prac.DesignPat.Proxy.LoggingProxy;

public class RealService implements Service {
    @Override
    public void performOperation(String data) {
        System.out.println("RealService: Processing data '" + data + "'");
    }
}
