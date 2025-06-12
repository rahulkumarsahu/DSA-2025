package com.dsa2025.learn.lld.designPatterns.template;

public abstract class PaymentFlow {

    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();

    // Template method
    public final void sendMoney() {
        // step1
        validateRequest();

        // step2
        debitAmount();

        // step3
        calculateFees();

        // step4
        creditAmount();
    }

}
