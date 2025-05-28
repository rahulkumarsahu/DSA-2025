package com.dsa2025.learn.lld.designPatterns.observerPattern.Observer;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to:" + emailId);
    }
}
