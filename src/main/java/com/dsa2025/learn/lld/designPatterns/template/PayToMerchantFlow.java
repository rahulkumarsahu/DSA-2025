package com.dsa2025.learn.lld.designPatterns.template;

public class PayToMerchantFlow extends PaymentFlow {

    @Override
    public void validateRequest() {
        System.out.println("Validate logic of PayToMerchantFlow");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debit the Amount logic of PayToMerchantFlow");
    }

    @Override
    public void calculateFees() {
        System.out.println("2% fees charged");
    }

    @Override
    public void creditAmount() {
        System.out.println("Credit amount logic of PayToMerchantFlow");
    }

}
