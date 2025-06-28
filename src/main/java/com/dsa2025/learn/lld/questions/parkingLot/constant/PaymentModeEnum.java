package com.dsa2025.learn.lld.questions.parkingLot.constant;

public enum PaymentModeEnum {

    CASH("Cash Payment"),
    CARD("Card Payment"),
    DIGITAL_WALLET("Digital Wallet"),
    UPI("UPI Payment");

    private final String displayName;

    PaymentModeEnum(String displayName) {
        this.displayName = displayName;
    }

}
