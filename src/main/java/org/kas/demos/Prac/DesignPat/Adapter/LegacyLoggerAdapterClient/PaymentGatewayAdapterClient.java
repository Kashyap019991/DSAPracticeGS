package org.kas.demos.Prac.DesignPat.Adapter.LegacyLoggerAdapterClient;
/*
The Adapter pattern helps you use a third-party library whose interface does
not align with your application's design.
Scenario: Your application needs to handle various payment gateways
(e.g., PayPal, Stripe) but wants to do so through a single, consistent
PaymentGateway interface. Each third-party provider, however, offers a different API.
Solution: Create an adapter for each payment gateway (e.g., PayPalAdapter,
StripeAdapter). Each adapter implements the PaymentGateway interface and
internally uses the specific methods of the third-party library.
 */
// Target interface for your application
interface PaymentGateway {
    void processPayment(String amount);
}

// Adaptee: An incompatible third-party API
class ThirdPartyPayPalAPI {
    public void makePayment(double value) {
        System.out.println("PayPal processing payment of $" + value);
    }
}

// Adapter: Wraps the PayPal API to fit your interface
class PayPalAdapter implements PaymentGateway {
    private ThirdPartyPayPalAPI payPalAPI;

    // ... constructor ...
    PayPalAdapter(ThirdPartyPayPalAPI payPalAPI){
        this.payPalAPI = payPalAPI;
    }

    @Override
    public void processPayment(String amountWithCurrency) {
        // 1. Type Conversion
        double amount = Double.parseDouble(amountWithCurrency.split(" ")[0]);

        // 2. Method name adaptation
        payPalAPI.makePayment(amount);
    }
}

// The client interacts with the unified interface
public class PaymentGatewayAdapterClient {
    public void checkout(PaymentGateway gateway, String amount) {
        gateway.processPayment(amount);
    }

    public static void main(String[] args) {
        PaymentGatewayAdapterClient store = new PaymentGatewayAdapterClient();
        
        // Use the PayPal API via the adapter
        ThirdPartyPayPalAPI payPalApi = new ThirdPartyPayPalAPI();
        PaymentGateway paymentAdapter = new PayPalAdapter(payPalApi);
        
        store.checkout(paymentAdapter, "99.99 USD");
    }
}
