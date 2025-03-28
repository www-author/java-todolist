package com.mtvs.todolist.global.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public final class Log {
    public static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void record(
            Level level,
            final String message
    ) {
        switch (level) {
            case INFO -> logger.info(message);
            case DEBUG -> logger.debug(message);
            case TRACE -> logger.trace(message);
            case WARN -> logger.warn(message);
            case ERROR -> logger.error(message);
            default -> throw new IllegalArgumentException();
        }
    }
}
