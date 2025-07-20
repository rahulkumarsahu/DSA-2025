package com.dsa2025.learn.lld.questions.parkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.PricingStrategy;


public class WithoutChargingCostComputation implements CostComputation {

    public PricingStrategy pricingStrategy;

    public WithoutChargingCostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double costComputation(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket);
    }
}
