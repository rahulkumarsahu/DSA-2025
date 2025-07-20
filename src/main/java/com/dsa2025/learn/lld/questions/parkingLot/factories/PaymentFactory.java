package com.dsa2025.learn.lld.questions.parkingLot.factories;

import com.dsa2025.learn.lld.questions.parkingLot.models.constant.PaymentType;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.CardPaymentStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.CashPaymentStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.PaymentStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.UPIPaymentStrategy;

public class PaymentFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case CASH -> new CashPaymentStrategy();
            case CARD -> new CardPaymentStrategy();
            case UPI -> new UPIPaymentStrategy();
        };
    }
}
