package com.mtvs.todolist.controller;

import com.mtvs.todolist.global.MenuState;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.util.Console;
import com.mtvs.todolist.view.RootView;

import static com.mtvs.todolist.global.MenuState.getMenu;

public class RootController {
    private final RootView rootView;

    private RootController() {
        rootView = RootView.getInstance();
    }

    public static RootController getInstance() {
        return new RootController();
    }

    public void execute() {
        this.rootView.showMenu();
        while (true) {
            MenuState menuState = getMenu(Console.open().nextInt());
            switch (menuState) {
                case SIGN_UP -> UserController.getInstance().signUp();
                //case LOGIN ->
                case EXIT -> rootView.exit();
                default -> System.out.println(Message.INVALID_MENU.getMessage());
            }
        }

    }
}
