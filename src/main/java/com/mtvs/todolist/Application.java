package com.mtvs.todolist;

import com.mtvs.todolist.controller.RootController;
import com.mtvs.todolist.global.util.Log;
import org.slf4j.event.Level;


public class Application {

    public static void main(String[] args) {
        try {
            RootController.getInstance().execute();
        } catch (Exception e) {
            Log.record(Level.ERROR, e.getMessage());
        }
    }
}
