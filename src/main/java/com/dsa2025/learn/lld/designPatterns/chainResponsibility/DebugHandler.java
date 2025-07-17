package com.dsa2025.learn.lld.designPatterns.chainResponsibility;

public class DebugHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }

}
