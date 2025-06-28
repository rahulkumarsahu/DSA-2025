package com.dsa2025.learn.lld.questions.parkingLot.cost;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public interface CostCalculation {

    /**
     * This method will be used to calculate price based on a pricing Strategy type
     * @param ticket ticket
     * @return int
     */
     int calculatePrice(Ticket ticket);
}
