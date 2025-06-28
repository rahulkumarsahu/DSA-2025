package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public interface PricingStrategy {

    /**
     * This method will be used to calculate the price based on hour, minute or default price
     * @param ticket ticket
     * @return int
     */
    int calculatePrice(Ticket ticket);
}
