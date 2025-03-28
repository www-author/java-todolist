package com.mtvs.todolist.controller;

import com.mtvs.todolist.dto.request.UserRequest;
import com.mtvs.todolist.global.util.Screen;
import com.mtvs.todolist.global.util.TimeManager;
import com.mtvs.todolist.service.UserService;
import com.mtvs.todolist.view.UserView;

public class UserController {
    private final UserView userView;
    private final UserService userService;

    private UserController() {
        this.userView = UserView.getInstance();
        this.userService = UserService.getInstance();
    }

    public static UserController getInstance() {
        return new UserController();
    }

    public void signUp() {
        this.userView.showSignUpMenu();
        UserRequest request = this.userView.signUp();
        this.userService.signUp(request);
        this.userView.printSignUp();
        TimeManager.delay(); // 2초 뒤 초기 화면으로 이동
        Screen.clear();// 기존의 화면을 Clear
        RootController.getInstance().execute();
    }
}
