package com.mtvs.todolist.controller;

import com.mtvs.todolist.view.RootView;

public class UserController implements TaskController {
    // TODO VIEW에서 로직관련 부분 별도 분리.
    private final RootView rootView;

    public UserController() {
        this.rootView = RootView.getInstance();
    }

    @Override
    public void execute() {

    }
}
