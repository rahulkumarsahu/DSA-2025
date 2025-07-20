package com.dsa2025.learn.lld.questions.parkingLot.strategy.payment;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid using UPI: " + amount);
    }
}
