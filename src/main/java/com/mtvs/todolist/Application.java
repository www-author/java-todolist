package com.mtvs.todolist;

import com.mtvs.todolist.controller.RootController;


public class Application {

    public static void main(String[] args) {
        RootController.getInstance().execute();
    }
}
