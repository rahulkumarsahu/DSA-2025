package com.dsa2025.learn.lld.questions.parkingLot.cost;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.PricingStrategy;

public class FourWheelerCostCalculation implements CostCalculation {

    private final PricingStrategy pricingStrategy;

    public FourWheelerCostCalculation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
    /**
     * This method will be used to calculate price based on a pricing Strategy type
     *
     * @param ticket ticket
     * @return int
     */
    @Override
    public int calculatePrice(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket);
    }
}
