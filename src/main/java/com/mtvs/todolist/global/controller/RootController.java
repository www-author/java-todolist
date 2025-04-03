package com.mtvs.todolist.global.controller;

import com.mtvs.todolist.domain.user.controller.UserController;
import com.mtvs.todolist.global.Menu;
import com.mtvs.todolist.global.MenuType;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.util.Console;
import com.mtvs.todolist.global.util.Log;
import com.mtvs.todolist.global.view.RootView;
import org.slf4j.event.Level;

import static com.mtvs.todolist.global.Menu.findByMenu;

public class RootController {
    public static RootController getInstance(){
        return new RootController();
    }

    public void execute() {
        try {
            RootView.getInstance().showMenu();
            while (true) {
                Menu menu = findByMenu(Console.open().nextInt(), MenuType.ROOT);
                switch (menu) {
                    case SIGN_UP -> UserController.getInstance().signUp();
                    case LOGIN ->  UserController.getInstance().login();
                    case EXIT -> RootView.getInstance().exit();
                    default -> System.out.println(Message.INVALID_MENU.getMessage());
                }
            }
        } catch (Exception e) {
            Log.record(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }
    }
}
