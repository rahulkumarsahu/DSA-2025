package com.dsa2025.learn.lld.designPatterns.chainResponsibility.handler;

import com.dsa2025.learn.lld.designPatterns.chainResponsibility.model.LogLevel;

public class ErrorHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("[ERROR] " + message + " - Logged to file and sent email alert");
    }
}
