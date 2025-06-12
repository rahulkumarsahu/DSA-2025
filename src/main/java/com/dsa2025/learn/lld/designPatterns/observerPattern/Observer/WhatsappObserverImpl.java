package com.dsa2025.learn.lld.designPatterns.observerPattern.Observer;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.StockObservable;

public class WhatsappObserverImpl implements NotificationAlertObserver {

    String mobileNumber;
    StockObservable stockObservable;

    public WhatsappObserverImpl(String mobileNumber, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void update() {
        sendMessage(mobileNumber, "product is in stock hurry up");
    }

    private void sendMessage(String mobileNumber, String msg) {
        System.out.println("message sent to:" + mobileNumber);
        System.out.println(stockObservable.getName());
        System.out.println("----------------------------------------");
    }
}
