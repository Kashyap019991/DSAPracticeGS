package org.kas.demos.Prac.DesignPat.Proxy.LoggingProxy;

import java.util.logging.Logger;

public class ProxyService implements Service {
    private static final Logger LOGGER = Logger.getLogger(ProxyService.class.getName());
    private RealService realService;

    public ProxyService(RealService realService) {
        this.realService = realService;
    }

    @Override
    public void performOperation(String data) {
        LOGGER.info("Proxy: Executing 'performOperation' with data '" + data + "'");
        
        // Delegate the call to the real service
        realService.performOperation(data);

        LOGGER.info("Proxy: 'performOperation' finished");
    }
}
