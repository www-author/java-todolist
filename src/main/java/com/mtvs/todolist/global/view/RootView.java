package com.mtvs.todolist.global.view;

import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.config.JDBCConnection;
import com.mtvs.todolist.global.util.Console;

public class RootView {
    private RootView() {}

    public static RootView getInstance() {
        return new RootView();
    }

    public void showMenu() {
        System.out.println(Message.START_MENU.getMessage());
    }

    public void exit() {
        System.out.println(Message.END_MENU.getMessage());
        JDBCConnection.close();
        Console.close();
        System.exit(0);
    }
}
