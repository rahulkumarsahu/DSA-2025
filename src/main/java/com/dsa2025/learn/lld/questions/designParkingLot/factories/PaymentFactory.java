package com.dsa2025.learn.lld.questions.designParkingLot.factories;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.PaymentType;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment.CardPaymentStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment.CashPaymentStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment.PaymentStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment.UPIPaymentStrategy;

public class PaymentFactory {

    public static PaymentStrategy getPricingStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case CASH -> new CashPaymentStrategy();
            case CARD -> new CardPaymentStrategy();
            case UPI -> new UPIPaymentStrategy();
        };
    }
}
