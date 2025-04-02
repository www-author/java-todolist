package com.mtvs.todolist.domain.user.dto.request;

import com.mtvs.todolist.domain.user.model.User;

public class SignUpRequest {
    private final String name;
    private final String email;
    private final String password;
    private final String confirmPassword;

    private SignUpRequest(
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

    public static SignUpRequest of(
            final String name,
            final String email,
            final String password,
            final String confirmPassword
    ) {
        return new SignUpRequest(name, email, password, confirmPassword);
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

    public User toEntity() {
        return User.of(
                this.name,
                this.password,
                this.confirmPassword,
                this.email
        );
    }
}
