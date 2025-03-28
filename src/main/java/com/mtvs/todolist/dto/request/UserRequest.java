package com.mtvs.todolist.dto.request;

public class UserRequest {
    private final String name;
    private final String email;
    private final String password;
    private final String confirmPassword;

    private UserRequest(
            final String name,
            final String email,
            final String password,
            final String confirmPassword
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static UserRequest of(
            final String name,
            final String email,
            final String password,
            final String confirmPassword
    ) {
        return new UserRequest(name, email, password, confirmPassword);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
