package com.mtvs.todolist.global.util;

import org.slf4j.event.Level;

import java.util.concurrent.TimeUnit;

public final class TimeManager {

    public static void delay(final long seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
    }
}
