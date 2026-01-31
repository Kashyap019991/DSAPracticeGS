package org.kas.demos.Prac.LLD.ParkingLotDesign;

import java.time.LocalDateTime;

interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        long durationHours = java.time.Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        // Assume a base rate of $10 per hour
        return durationHours * 10.0;
    }
}

class SpecialEventPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        // Implement special event logic here
        return 50.0; // Flat rate for a special event
    }
}
