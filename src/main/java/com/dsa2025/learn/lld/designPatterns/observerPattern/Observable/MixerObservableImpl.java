package com.dsa2025.learn.lld.designPatterns.observerPattern.Observable;

import com.dsa2025.learn.lld.designPatterns.observerPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class MixerObservableImpl implements StockObservable {

    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void register(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver notificationAlertObserver : observerList) {
            notificationAlertObserver.update();
        }
    }

    // when we will get update then we have to notify...
    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount == 0) {
            // new count is going to come notify subscriber and update the count...
            notifySubscriber();
        }
        stockCount = stockCount + newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public String getName() {
        return "Mixer";
    }
}
