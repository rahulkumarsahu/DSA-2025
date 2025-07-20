package com.dsa2025.learn.lld.questions.parkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.PricingStrategy;

public class WithChargingCostComputation implements CostComputation {

    public PricingStrategy pricingStrategy;

    public WithChargingCostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double costComputation(Ticket ticket) {
        // here can have some diff. parameter for
        return pricingStrategy.calculatePrice(ticket);
    }
}
