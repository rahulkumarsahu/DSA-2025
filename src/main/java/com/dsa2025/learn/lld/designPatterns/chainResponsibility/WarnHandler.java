package com.dsa2025.learn.lld.designPatterns.chainResponsibility;

public class WarnHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.WARN;
    }

    @Override
    protected void write(String message) {
        System.out.println("[WARN] " + message + " - Logged to file");
    }
}
