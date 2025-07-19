package com.dsa2025.learn.lld.designPatterns.chainResponsibility.handler;

import com.dsa2025.learn.lld.designPatterns.chainResponsibility.model.LogLevel;

public class InfoHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("[INFO] " + message);
    }
}
