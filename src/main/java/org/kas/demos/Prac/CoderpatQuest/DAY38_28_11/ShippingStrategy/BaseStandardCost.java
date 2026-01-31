package org.kas.demos.Prac.CoderpatQuest.DAY38_28_11.ShippingStrategy;

import java.math.BigDecimal;

// Rule 1: Standard Shipping Cost
 class BaseStandardCost implements ShippingCostStrategy {
    private static final BigDecimal STANDARD_SHIPPING_COST = new BigDecimal("10.00");

    @Override
    public BigDecimal calculate(BigDecimal orderTotal, boolean isInternational, BigDecimal currentCost) {
        // This sets the initial base cost
        return currentCost.add(STANDARD_SHIPPING_COST);
    }
}

// Rule 2: Free Shipping over $50
 class FreeShippingOver50 implements ShippingCostStrategy {
    private static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("50.00");

    @Override
    public BigDecimal calculate(BigDecimal orderTotal, boolean isInternational, BigDecimal currentCost) {
        // If order total is over 50, override current cost with free shipping (0.00)
        if (orderTotal.compareTo(FREE_SHIPPING_THRESHOLD) > 0) {
            return new BigDecimal("0.00");
        }
        return currentCost; // Otherwise, keep the current cost
    }
}

// Rule 3: International Surcharge
 class InternationalSurcharge implements ShippingCostStrategy {
    private static final BigDecimal INTERNATIONAL_SURCHARGE = new BigDecimal("20.00");

    @Override
    public BigDecimal calculate(BigDecimal orderTotal, boolean isInternational, BigDecimal currentCost) {
        if (isInternational) {
            return currentCost.add(INTERNATIONAL_SURCHARGE);
        }
        return currentCost;
    }
}
