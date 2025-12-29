package org.kas.demos.Prac.DesignPat.Proxy.ProxyService;

public class ServiceProxy implements Service {
        private RealService realService;

        public ServiceProxy() {
            // Lazy initialization or other logic can be added here
            this.realService = new RealService();
        }

        @Override
        public void performAction() {
            System.out.println("ServiceProxy: Intercepting request...");
            // Add pre-processing logic (e.g., logging, security checks, caching)
            realService.performAction(); // Delegate to the real service
            // Add post-processing logic (e.g., logging, response modification)
            System.out.println("ServiceProxy: Request processed.");
        }
    }