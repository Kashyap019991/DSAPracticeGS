package org.kas.demos.Prac.DesignPat.Proxy.ProxyService;

public class Client {
        public static void main(String[] args) {
            Service service = new ServiceProxy();
            service.performAction();
        }
    }