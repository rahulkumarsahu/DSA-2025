package com.dsa2025.learn.lld.designPatterns.template;

public class Client {

    public static void main(String[] args) {
        PaymentFlow payToFriend = new PayToFriend();
        System.out.println("--- Pay to Friend Flow ---");
        payToFriend.sendMoney();

        System.out.println();

        PaymentFlow payToMerchant = new PayToMerchantFlow();
        System.out.println("--- Pay to Merchant Flow ---");
        payToMerchant.sendMoney();
    }

}
