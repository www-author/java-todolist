package com.mtvs.todolist;

import com.mtvs.todolist.controller.RootController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            RootController.getInstance().execute();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
