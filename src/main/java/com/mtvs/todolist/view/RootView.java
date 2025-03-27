package com.mtvs.todolist.view;

import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.Menu;
import com.mtvs.todolist.util.Console;

import static com.mtvs.todolist.global.Menu.*;

public class RootView {
    private RootView() {}

    public static RootView getInstance() {
        return new RootView();
    }

    public void showMenu() {
        while (true) {
            System.out.println(Message.START_MENU.getMessage());
            Menu menu = getMenu(Console.open().nextInt());
            switch (menu) {
                //case SIGN_UP, LOGIN -> // TODO 각자 로직 처리
                case EXIT -> close();
                default -> System.out.println(Message.INVALID_MENU.getMessage());
            }
        }
    }

    private void close() {
        System.out.println(Message.END_MENU.getMessage());
        Console.close();
        System.exit(0);
    }
}
