package com.mtvs.todolist.global.util;

import org.slf4j.event.Level;

import java.util.concurrent.TimeUnit;

public final class TimeManager {

    public static void delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2L);
    }
}
