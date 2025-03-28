package com.mtvs.todolist.view;

import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.util.Console;

import java.util.Scanner;

public class RootView {
    private final Scanner scanner;

    private RootView() {
        this.scanner = Console.open();
    }

    public static RootView getInstance() {
        return new RootView();
    }

    public void showMenu() {
        System.out.println(Message.START_MENU.getMessage());
    }

    public void exit() {
        System.out.println(Message.END_MENU.getMessage());
        Console.close();
        System.exit(0);
    }
}
