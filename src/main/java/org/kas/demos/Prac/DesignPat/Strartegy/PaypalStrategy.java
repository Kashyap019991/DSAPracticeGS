package org.kas.demos.Prac.DesignPat.Strartegy;

class PaypalStrategy implements PaymentStrategy {


    String name;
    String paypalId;

    public PaypalStrategy(String name, String paypalId) {
        this.name = name;
        this.paypalId = paypalId;
    }


    public void pay(int amount) {
        System.out.println("Paypal Payment" + amount);
    }


}