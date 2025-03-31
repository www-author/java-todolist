package com.mtvs.todolist.global.util;

import org.slf4j.event.Level;

import java.util.concurrent.TimeUnit;

public final class TimeManager {

    public static void delay()  {
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
    }
}
