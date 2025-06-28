package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DefaultPrice implements PricingStrategy {
    /**
     * This method will be used to calculate the price based on minute
     *
     * @param ticket ticket
     * @return int
     */
    @Override
    public int calculatePrice(Ticket ticket) {
        return ticket.parkingSpot().getBasePrice();
    }
}
