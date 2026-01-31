package org.kas.demos.Prac.CoderpatQuest.DAY38_28_11.ShippingStrategy;

import java.math.BigDecimal;

/**
 * Interface for all shipping calculation strategies.
 */
public interface ShippingCostStrategy {
    /**
     * Calculates an additional cost component based on the order details.
     * @param orderTotal The current total value of the order.
     * @param isInternational Flag for international shipping.
     * @param currentCost The shipping cost calculated by previous strategies in a chain.
     * @return The calculated cost component (can be negative for discounts).
     */
    BigDecimal calculate(BigDecimal orderTotal, boolean isInternational, BigDecimal currentCost);
}
