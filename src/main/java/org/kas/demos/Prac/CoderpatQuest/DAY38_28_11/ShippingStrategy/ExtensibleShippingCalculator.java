package org.kas.demos.Prac.CoderpatQuest.DAY38_28_11.ShippingStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExtensibleShippingCalculator {
    private final List<ShippingCostStrategy> rules = new ArrayList<>();

    public ExtensibleShippingCalculator() {
        // Add rules in the order they should be evaluated
        rules.add(new BaseStandardCost());
        rules.add(new FreeShippingOver50());
        rules.add(new InternationalSurcharge());
    }

    /**
     * Calculates the shipping cost by applying all defined rules sequentially.
     *
     * @param orderTotal The total value of the items in the order.
     * @param isInternational A boolean indicating international shipping.
     * @return The final total shipping cost.
     */
    public BigDecimal calculateShipping(BigDecimal orderTotal, boolean isInternational) {
        BigDecimal finalCost = new BigDecimal("0.00");

        for (ShippingCostStrategy rule : rules) {
            // Each rule potentially modifies the running cost
            finalCost = rule.calculate(orderTotal, isInternational, finalCost);
        }

        return finalCost;
    }
}
