package com.dsa2025.learn.lld.questions.parkingLot.strategy;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourPricing implements PricingStrategy {
    /**
     * This method will be used to calculate the price based on hour
     *
     * @param ticket ticket
     * @return int
     */
    @Override
    public int calculatePrice(Ticket ticket) {

        LocalDateTime entryTime = ticket.entryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        long hours = ChronoUnit.HOURS.between(entryTime, exitTime);
        if (hours == 0) hours = 1; // Minimum 1-hour charge

        return (int) (hours * ticket.parkingSpot().getBasePrice());

    }
}
