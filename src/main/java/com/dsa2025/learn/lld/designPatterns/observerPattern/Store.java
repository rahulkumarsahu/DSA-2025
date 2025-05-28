package com.dsa2025.learn.lld.designPatterns.observerPattern;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.IphoneObservableImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.StockObservable;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.EmailAlertObserverImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.MobileAlertObserverImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz123@gmail.com", stockObservable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("xyz_username", stockObservable);
        // added to get notify observer to observable....
        stockObservable.register(observer1);
        stockObservable.register(observer2);

        stockObservable.setStockCount(10);
        // it will not notify because stock is already up....
        stockObservable.setStockCount(100);
        stockObservable.setStockCount(0);
    }
}
