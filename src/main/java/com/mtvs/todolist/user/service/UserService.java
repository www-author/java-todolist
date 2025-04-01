package com.mtvs.todolist.user.service;

import com.mtvs.todolist.user.dao.UserDao;
import com.mtvs.todolist.user.dto.request.LoginRequest;
import com.mtvs.todolist.user.dto.request.SignUpRequest;
import com.mtvs.todolist.user.dto.response.UserResponse;
import com.mtvs.todolist.user.exception.UserNotFoundException;
import com.mtvs.todolist.user.model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao;

    public UserService() throws SQLException {
        this.userDao = new UserDao();
    }

    public static UserService getInstance() throws SQLException {
        return new UserService();
    }

    public boolean signUp(final SignUpRequest request) {
        User user = request.toEntity();
        boolean isUser = this.userDao.existByEmail(request.getEmail());
        if (isUser) {
            throw new UserNotFoundException();
        };
        // TODO (refactor) : 비밀번호 저장 전 암호화
        return this.userDao.save(user);
    }

    public UserResponse login(final LoginRequest request) {
        User eixstingUser = this.userDao.findByEmail(request.email())
                .orElseThrow(UserNotFoundException::new);
        User.validatePasswordMatches(
                eixstingUser.getPassword(),
                request.password().strip()
        );
        return UserResponse.from(eixstingUser);
    }
}
