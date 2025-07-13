package com.dsa2025.learn.lld.designPatterns.proxy;

public class ProxyPatternExample {
    public static void main(String[] args) {
        // Create proxy images - no actual loading happens yet
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("Images created (proxies)");

        // First display - loads the actual image
        System.out.println("\nFirst display:");
        image1.display();

        // Second display - uses already loaded image
        System.out.println("\nSecond display:");
        image1.display();

        // Display second image
        System.out.println("\nDisplay second image:");
        image2.display();
    }
}
