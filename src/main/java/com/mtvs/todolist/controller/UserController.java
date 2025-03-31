package com.mtvs.todolist.controller;

import com.mtvs.todolist.dto.request.UserRequest;
import com.mtvs.todolist.global.util.Screen;
import com.mtvs.todolist.global.util.TimeManager;
import com.mtvs.todolist.service.UserService;
import com.mtvs.todolist.view.UserView;

import java.sql.SQLException;

public class UserController {
    private final UserView userView;
    private final UserService userService;

    private UserController() throws SQLException {
        this.userView = UserView.getInstance();
        this.userService = UserService.getInstance();
    }

    public static UserController getInstance() throws SQLException {
        return new UserController();
    }

    public void signUp() {
        this.userView.showSignUpMenu();
        UserRequest request = this.userView.signUp();
        this.userView.printSignUp(this.userService.signUp(request));
        TimeManager.delay(); // 2초 뒤 초기 화면으로 이동
        Screen.clear();// 기존의 화면을 Clear
        RootController.getInstance().execute();
    }
}
