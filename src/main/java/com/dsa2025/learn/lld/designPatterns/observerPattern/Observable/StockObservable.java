package com.dsa2025.learn.lld.designPatterns.observerPattern.Observable;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.NotificationAlertObserver;

public interface StockObservable {

    void register(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscriber();

    void setStockCount(int newStockAdded);

    int getStockCount();

    String getName();
}
