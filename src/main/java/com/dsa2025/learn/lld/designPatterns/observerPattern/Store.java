package com.dsa2025.learn.lld.designPatterns.observerPattern;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.IphoneObservableImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.MixerObservableImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observable.StockObservable;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.EmailAlertObserverImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.MobileAlertObserverImpl;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.NotificationAlertObserver;
import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.WhatsappObserverImpl;

public class Store {

    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();
        StockObservable mixerStockObservable = new MixerObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz123@gmail.com", mixerStockObservable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("xyz_username", iphoneStockObservable);
        NotificationAlertObserver observer3 = new WhatsappObserverImpl("1234567890", mixerStockObservable);
        // added to get notify observer to observable....
        mixerStockObservable.register(observer1);
        iphoneStockObservable.register(observer2);
        mixerStockObservable.register(observer3);

        iphoneStockObservable.setStockCount(10);
        // it will not notify because stock is already up....
        iphoneStockObservable.setStockCount(100);
        iphoneStockObservable.setStockCount(0);

        mixerStockObservable.setStockCount(3);
    }
}
