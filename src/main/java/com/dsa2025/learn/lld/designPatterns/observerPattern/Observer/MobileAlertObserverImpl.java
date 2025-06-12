package com.dsa2025.learn.lld.designPatterns.observerPattern.Observer;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    // to get either for iphone or mixer
    StockObservable stockObservable;

    public MobileAlertObserverImpl(String userName, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "product is in stock hurry up");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to:" + userName);
        System.out.println(stockObservable.getName());
        System.out.println("----------------------------------------");
    }
}
