package com.dsa2025.learn.lld.questions.carRentalSystem.model.payment;

import java.time.LocalDate;

public class Payment {

    private String paymentId;
    private double amount;
    private String paymentMethod;
    private LocalDate paymentDate;

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDate.now();
    }


    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void processPayment() {
        System.out.println("Payment processed: ₹" + amount + " via " + paymentMethod);
    }

}
