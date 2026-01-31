package org.kas.demos.Prac.CoderpatQuest.DAY38_28_11.ShippingStrategy;

import java.math.BigDecimal;
/*

For an e-commerce website, write a Java method that calculates the shipping cost for an order. Here is the business rule:
- Standard shipping is $10
- If the total order is over $50, shipping is free
- If it's an international order, add a $20 surcharge

 */
public class Demo {
    public static void main(String[] args) {
        ExtensibleShippingCalculator calculator = new ExtensibleShippingCalculator();

        // Domestic order under $50 (Expected: $10.00)
        BigDecimal cost1 = calculator.calculateShipping(new BigDecimal("35.00"), false);
        System.out.println("Domestic order $35.00: $" + cost1);

        // Domestic order over $50 (Expected: $0.00)
        BigDecimal cost2 = calculator.calculateShipping(new BigDecimal("75.50"), false);
        System.out.println("Domestic order $75.50: $" + cost2);

        // International order under $50 (Expected: $10.00 + $20.00 = $30.00)
        BigDecimal cost3 = calculator.calculateShipping(new BigDecimal("49.99"), true);
        System.out.println("International order $49.99: $" + cost3);

        // International order over $50 (Expected: $0.00 + $20.00 = $20.00)
        BigDecimal cost4 = calculator.calculateShipping(new BigDecimal("150.00"), true);
        System.out.println("International order $150.00: $" + cost4);
    }
}
