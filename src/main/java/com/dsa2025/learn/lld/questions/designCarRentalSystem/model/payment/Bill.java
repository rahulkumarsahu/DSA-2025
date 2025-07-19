package com.dsa2025.learn.lld.questions.designCarRentalSystem.model.payment;

import java.time.LocalDate;

public class Bill {

    private String billId;
    private double price;
    private LocalDate billDate;

    public Bill(String billId, double price) {
        this.billId = billId;
        this.price = price;
        this.billDate = LocalDate.now();
    }

    public String getBillId() { return billId; }
    public double getPrice() { return price; }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public void generateBill() {
        System.out.println("Bill generated: " + billId + " - ₹" + price);
    }
}
