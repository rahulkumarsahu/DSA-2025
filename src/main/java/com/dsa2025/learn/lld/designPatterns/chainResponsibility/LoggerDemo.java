package com.dsa2025.learn.lld.designPatterns.chainResponsibility;

public class LoggerDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        System.out.println("Testing Chain of Responsibility Logger:");
        System.out.println("=====================================");

        logger.debug("This is a debug message");
        logger.info("Application started successfully");
        logger.warn("Memory usage is high");
        logger.error("Database connection failed");

        System.out.println("\nEach message goes through entire chain,");
        System.out.println("but only appropriate handler processes it!");
    }

}
