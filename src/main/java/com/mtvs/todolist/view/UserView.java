package com.mtvs.todolist.view;

import com.mtvs.todolist.user.dto.request.LoginRequest;
import com.mtvs.todolist.user.dto.request.SignUpRequest;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.util.Console;
import com.mtvs.todolist.user.dto.response.UserResponse;

public class UserView {
    private UserView() {
    }

    public static UserView getInstance() {
        return new UserView();
    }

    public void showMenu(String message) {
        System.out.println(message);
    }

    public void printSignUp(boolean isSignUp) {
        System.out.println(isSignUp ? Message.COMPLETE_SIGN_UP.getMessage() : ErrorCode.USER_REGISTRATION_FAILED.getMessage());
    }

    public void printLogin(final UserResponse response) {
        System.out.println(Message.SUCCESS_LOGIN.getMessage() + response.getName() + "님");
    }

    public SignUpRequest signUp() {
        System.out.flush(); // 이전 콘솔 출력 메시지 초기화를 위헤 호출
        Console.reset();

        System.out.println(Message.ENTER_YOUR_NAME.getMessage());
        String username = Console.open().nextLine();

        System.out.println(Message.ENTER_YOUR_EMAIL.getMessage());
        String email = Console.open().nextLine();

        System.out.println(Message.ENTER_YOUR_PASSWORD.getMessage());
        String password = Console.open().nextLine();

        System.out.println(Message.ENTER_CONFIRM_PASSWORD.getMessage());
        String confirmPassword = Console.open().nextLine();

        return SignUpRequest.of(
                username,
                email,
                password,
                confirmPassword
        );
    }

    public LoginRequest login() {
        System.out.flush(); // 이전 콘솔 출력 메시지 초기화를 위헤 호출
        Console.reset();

        System.out.println(Message.ENTER_YOUR_EMAIL.getMessage());
        String email = Console.open().nextLine();

        System.out.println(Message.ENTER_YOUR_LOGIN_PASSWORD.getMessage());
        String password = Console.open().nextLine();

        return LoginRequest.of(email, password);
    }
}
