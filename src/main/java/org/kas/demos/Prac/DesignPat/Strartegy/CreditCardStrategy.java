package org.kas.demos.Prac.DesignPat.Strartegy;

class CreditCardStrategy implements PaymentStrategy{
    String name;
    String cardNo;
    String cvv;

    public CreditCardStrategy(String name, String cardNo, String cvv) {
        this.name = name;
        this.cardNo = cardNo;
        this.cvv = cvv;
    }

    public void pay(int amount) {
        System.out.println("paid by credit card"+amount);
    }
}
