package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MinutePrice implements PricingStrategy {
    /**
     * This method will be used to calculate the price based on default price
     *
     * @param ticket ticket
     * @return int
     */
    @Override
    public int calculatePrice(Ticket ticket) {
        LocalDateTime entryTime = ticket.entryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        long minutes = ChronoUnit.MINUTES.between(entryTime, exitTime);
        if (minutes == 0) minutes = 1; // Minimum 1-minute charge

        // Price per minute = basePrice / 60
        return (int) (minutes * (ticket.parkingSpot().getBasePrice()));
    }
}
