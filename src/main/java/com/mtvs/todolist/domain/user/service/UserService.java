package com.mtvs.todolist.domain.user.service;

import com.mtvs.todolist.domain.user.dao.UserDao;
import com.mtvs.todolist.domain.user.dto.request.LoginRequest;
import com.mtvs.todolist.domain.user.dto.request.SignUpRequest;
import com.mtvs.todolist.domain.user.dto.response.UserResponse;
import com.mtvs.todolist.domain.user.exception.UserNotFoundException;
import com.mtvs.todolist.domain.user.model.User;

public class UserService {
    private final UserDao userDao;

    private UserService() {
        this.userDao = new UserDao();
    }

    public static UserService getInstance() {
        return new UserService();
    }

    public boolean signup(final SignUpRequest request) {
        User user = request.toEntity();
        boolean isUser = this.userDao.existByEmail(request.getEmail());
        if (isUser) {
            throw new UserNotFoundException();
        };
        return this.userDao.save(user);
    }

    public UserResponse login(final LoginRequest request) {
        User user = findByEmail(request.email().strip());
        User.validatePasswordMatches(request.password().strip(), user.getPassword());
        return UserResponse.from(user);
    }

    public User findByEmail(final String email) {
        return userDao.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
}
