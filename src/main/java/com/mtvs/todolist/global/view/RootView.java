package com.mtvs.todolist.global.view;

import com.mtvs.todolist.global.Menu;
import com.mtvs.todolist.global.MenuType;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.config.JDBCConnection;
import com.mtvs.todolist.global.controller.RootController;
import com.mtvs.todolist.global.util.Console;
import com.mtvs.todolist.global.util.TimeManager;

import static com.mtvs.todolist.global.Menu.findByMenu;

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

    public Menu findMenu() {
        if (Console.isInvalidInt()){
            return findByMenu(Console.open().nextInt(), MenuType.ROOT);
        }
        return Menu.DEFAILT;
    }

    public void retryMenuSelection() {
        System.out.flush();
        Console.reset();
        System.out.println(Message.INVALID_MENU.getMessage());
        TimeManager.delay(1L);
        RootController.getInstance().execute();
    }
}
