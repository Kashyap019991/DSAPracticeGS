package org.kas.demos.Prac.DesignPat.Strartegy;

class Demo{
    public static void main(String[] args) {

        new StrategyDecide(new CreditCardStrategy("kas","123456789","123"),20).checkout(20);
        new StrategyDecide(new PaypalStrategy("Kashyap","123456666"),30).checkout(30);
    }

}