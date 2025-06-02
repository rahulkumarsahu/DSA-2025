package com.dsa2025.learn.lld.designPatterns.facade.example2;

public class OrderClient {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.createOrder(121);
    }
}

