package com.mtvs.todolist.domain.user.controller;

import com.mtvs.todolist.domain.todolist.controller.TodoListController;
import com.mtvs.todolist.domain.user.dto.request.LoginRequest;
import com.mtvs.todolist.domain.user.dto.request.SignUpRequest;
import com.mtvs.todolist.domain.user.dto.response.UserResponse;
import com.mtvs.todolist.domain.user.service.UserService;
import com.mtvs.todolist.domain.user.view.UserView;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.controller.RootController;
import com.mtvs.todolist.global.util.TimeManager;

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
        userView.showMenu(Message.INTRO.makeMessage("Sign Up"));
        SignUpRequest request = userView.signUp();
        userView.printSignUp(userService.signup(request));
        TimeManager.delay(2L); // 2초 지연
        RootController.getInstance().execute();
    }

    public void login()  {
        userView.showMenu(Message.INTRO.makeMessage("Login"));
        LoginRequest request = userView.login();
        UserResponse response = userService.login(request);
        TodoListController.getInstance().showMenu(response); // 메인 화면으로 이동
    }

    public void logout() {
        System.out.println(Message.LOGOUT.getMessage());
        TimeManager.delay(3L);
        RootController.getInstance().execute(); // 로그아웃 후 최초 화면으로 이동
    }
}
