package com.dsa2025.learn.lld.solid;

// Interface should be such they should not implement unnecessary function they do not need --> Interface Segmentation
public interface RestaurantEmployee {
    void washDishes();
    void serveCustomer();
    void cookFood();
}

class Waiter implements RestaurantEmployee {

    @Override
    public void washDishes() {

    }

    @Override
    public void serveCustomer() {

    }

    @Override
    public void cookFood() {

    }
}

// so here waiter does not need to cook food or wash dishes right?? so it is not following the principle...

interface WaiterInterface {
    void serveCustomer();
    void takeOrder();
}

interface ChefInterface {
    void cookFood();
    void decideMenu();
}

class WaiterEmployee implements WaiterInterface {

    @Override
    public void serveCustomer() {

    }

    @Override
    public void takeOrder() {

    }
}

class Chef implements ChefInterface{

    @Override
    public void cookFood() {

    }

    @Override
    public void decideMenu() {

    }
}