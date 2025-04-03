package com.mtvs.todolist.global.controller;

import com.mtvs.todolist.domain.user.controller.UserController;
import com.mtvs.todolist.global.util.Log;
import com.mtvs.todolist.global.view.RootView;
import org.slf4j.event.Level;

public class RootController {
    public static RootController getInstance(){
        return new RootController();
    }

    public void execute() {
        try {
            RootView rootView = RootView.getInstance();
            rootView.showMenu();
            while (true) switch (rootView.findMenu()) {
                case SIGN_UP -> UserController.getInstance().signUp();
                case LOGIN ->  UserController.getInstance().login();
                case EXIT -> RootView.getInstance().exit();
                default -> rootView.retryMenuSelection();
            }
        } catch (Exception e) {
            Log.record(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }
    }


}
