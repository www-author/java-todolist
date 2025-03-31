package com.mtvs.todolist.view;

import com.mtvs.todolist.dto.request.UserRequest;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.util.Console;

public class UserView {
    private UserView() {
    }

    public static UserView getInstance() {
        return new UserView();
    }

    public void showSignUpMenu() {
        System.out.println(Message.SIGN_UP_INTRO.getMessage());
    }

    public void printSignUp(boolean isSignUp) {
        System.out.println(isSignUp ? Message.COMPLETE_SIGN_UP.getMessage() : ErrorCode.USER_REGISTRATION_FAILED.getMessage());
    }

    public UserRequest signUp() {
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

        return UserRequest.of(
                username,
                email,
                password,
                confirmPassword
        );
    }
}
