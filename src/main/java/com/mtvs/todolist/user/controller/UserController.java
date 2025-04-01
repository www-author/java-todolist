package com.mtvs.todolist.user.controller;

import com.mtvs.todolist.controller.RootController;
import com.mtvs.todolist.user.dto.request.LoginRequest;
import com.mtvs.todolist.user.dto.request.SignUpRequest;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.util.Screen;
import com.mtvs.todolist.global.util.TimeManager;
import com.mtvs.todolist.user.dto.response.UserResponse;
import com.mtvs.todolist.user.service.UserService;
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
        this.userView.showMenu(Message.SIGN_UP_INTRO.getMessage());
        SignUpRequest request = this.userView.signUp();
        this.userView.printSignUp(this.userService.signUp(request));
        TimeManager.delay(); // 2초 뒤 초기 화면으로 이동
        Screen.clear();// 기존의 화면을 Clear
        RootController.getInstance().execute();
    }

    public void login() {
        this.userView.showMenu(Message.LOGIN_INTRO.getMessage());
        LoginRequest request = this.userView.login();
        UserResponse response = this.userService.login(request);
        this.userView.printLogin(response);
    }
}
