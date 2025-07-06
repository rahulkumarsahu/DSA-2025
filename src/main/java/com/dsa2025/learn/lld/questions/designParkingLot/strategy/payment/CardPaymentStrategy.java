package com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid using Card: " + amount);
    }
}
