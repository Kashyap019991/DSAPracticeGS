package org.kas.demos.Prac.DesignPat.Proxy.ProxyService;

public class RealService implements Service {
        @Override
        public void performAction() {
            System.out.println("RealService: Performing the actual action.");
        }
    }