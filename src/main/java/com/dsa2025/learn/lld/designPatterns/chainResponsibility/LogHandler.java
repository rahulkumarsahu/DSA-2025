package com.dsa2025.learn.lld.designPatterns.chainResponsibility;

public abstract class LogHandler {

    protected LogHandler nextHandler;

    // Set next handler in chain
    public void setNext(LogHandler handler) {
        this.nextHandler = handler;
    }

    // Handle log message
    public void handle(LogLevel level, String message) {
        if (canHandle(level)) {
            write(message);
        }

        // Always pass to next handler in chain
        if (nextHandler != null) {
            nextHandler.handle(level, message);
        }
    }

    // Each handler checks if it handles this specific level
    protected abstract boolean canHandle(LogLevel level);

    // Each handler implements its own writing logic
    protected abstract void write(String message);
}
