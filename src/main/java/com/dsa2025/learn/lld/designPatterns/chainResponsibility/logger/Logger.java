package com.dsa2025.learn.lld.designPatterns.chainResponsibility.logger;

import com.dsa2025.learn.lld.designPatterns.chainResponsibility.handler.*;
import com.dsa2025.learn.lld.designPatterns.chainResponsibility.model.LogLevel;

public class Logger {

    private static Logger instance;
    private final LogHandler handlerChain;

    private Logger() {
        // Setup chain: Debug -> Info -> Warn -> Error
        DebugHandler debug = new DebugHandler();
        InfoHandler info = new InfoHandler();
        WarnHandler warn = new WarnHandler();
        ErrorHandler error = new ErrorHandler();

        // Build the chain
        debug.setNext(info);
        info.setNext(warn);
        warn.setNext(error);

        handlerChain = debug;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Simple logging methods
    public void debug(String message) {
        handlerChain.handle(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        handlerChain.handle(LogLevel.INFO, message);
    }

    public void warn(String message) {
        handlerChain.handle(LogLevel.WARN, message);
    }

    public void error(String message) {
        handlerChain.handle(LogLevel.ERROR, message);
    }
}
