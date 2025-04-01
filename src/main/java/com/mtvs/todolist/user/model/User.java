package com.mtvs.todolist.user.model;

import com.mtvs.todolist.global.exception.BusinessException;
import com.mtvs.todolist.global.model.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import static com.mtvs.todolist.global.error.ErrorCode.*;

public class User extends BaseEntity {
    private int id;
    private String name;
    private String password;
    private String email;

    private final static int MIN_PASSWORD_LENGTH = 8;
    private final static int MAX_PASSWORD_LENGTH = 12;

    private User(
            final String name,
            final String password,
            final String confirmPassword,
            final String email
    ) {
        validateUserName(name);
        validateUserEmail(email);
        validatePassword(password, confirmPassword);

        this.name = name;
        this.password = password;
        this.email = email;
    }

    private User(
            final Integer id,
            final String name,
            final String password,
            final String email
    ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public static User of(
            final int id,
            final String name,
            final String password,
            final String email
    ) {
        return new User(id, name, password, email);
    }

    public static User of(
        final String name,
        final String password,
        final String confirmPassword,
        final String email
    ) {
        return new User(name, password, confirmPassword, email);
    }

    public void validateUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            throw new BusinessException(USER_NAME_REQUIRED);
        }
    }

    public void validatePassword(
            final String password,
            final String confirmPassword
    ) {
        validatePasswordLength(password);
        validatePasswordMatches(password, confirmPassword);
    }

    // 비밀 번호와 비밀 번호 확인 일치 여부
    public static void validatePasswordMatches(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new BusinessException(NOT_MATCH_PASSWORD);
        }
    }

    // 비밀번호 길이 제한 확인
    public static void validatePasswordLength(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new BusinessException(INVALID_PASSWORD);
        }
    }

    private void validateUserEmail(String email) {
        if (StringUtils.isNotBlank(email) ||
                email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
        ) {
            return;
        }
        throw new BusinessException(INVALID_EMAIL);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
