package com.dsa2025.learn.lld.questions.parkingLot.factory;

import com.dsa2025.learn.lld.questions.parkingLot.constant.PaymentModeEnum;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public class PaymentProcessor {

    public static boolean processPayment(int amount, String paymentMode, Ticket ticket) {
        try {
            PaymentModeEnum mode = PaymentModeEnum.valueOf(paymentMode.toUpperCase());

            return switch (mode) {
                case CASH -> processCashPayment(amount, ticket);
                case CARD -> processCardPayment(amount, ticket);
                case DIGITAL_WALLET -> processDigitalWalletPayment(amount, ticket);
                case UPI -> processUPIPayment(amount, ticket);
            };
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid payment mode: " + paymentMode);
            return false;
        }
    }

    private static boolean processCashPayment(int amount, Ticket ticket) {
        System.out.println("Processing cash payment of ₹" + amount + " for ticket: " + ticket.ticketId());
        // Simulate cash payment processing
        return true;
    }

    private static boolean processCardPayment(int amount, Ticket ticket) {
        System.out.println("Processing card payment of ₹" + amount + " for ticket: " + ticket.ticketId());
        // Simulate card payment processing
        return true;
    }

    private static boolean processDigitalWalletPayment(int amount, Ticket ticket) {
        System.out.println("Processing digital wallet payment of ₹" + amount + " for ticket: " + ticket.ticketId());
        // Simulate digital wallet payment processing
        return true;
    }

    private static boolean processUPIPayment(int amount, Ticket ticket) {
        System.out.println("Processing UPI payment of ₹" + amount + " for ticket: " + ticket.ticketId());
        // Simulate UPI payment processing
        return true;
    }

}
