package com.dsa2025.learn.lld.designPatterns.facade.example2;

public class ProductDAO {

    public Product getProduct(int productId) {
        System.out.println("Getting product with ID: " + productId);
        return new Product();
    }

}
