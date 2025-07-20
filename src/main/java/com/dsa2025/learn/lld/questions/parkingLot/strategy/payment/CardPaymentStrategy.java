package com.dsa2025.learn.lld.questions.parkingLot.strategy.payment;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid using Card: " + amount);
    }
}
