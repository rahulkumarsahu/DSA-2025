package com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        return ticket.parkingSpot().getBasePrice();
    }
}
