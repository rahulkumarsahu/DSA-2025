package com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing;

import com.dsa2025.learn.lld.questions.designParkingLot.models.ticket.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        return ticket.getParkingSpot().getBasePrice();
    }
}
