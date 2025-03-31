package com.mtvs.todolist.service;

import com.mtvs.todolist.dao.UserDao;
import com.mtvs.todolist.dto.request.UserRequest;
import com.mtvs.todolist.model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao;

    public UserService() throws SQLException {
        this.userDao = new UserDao();
    }

    public static UserService getInstance() throws SQLException {
        return new UserService();
    }

    // todo 특정 이메일 사용자 조회 (EXIST)

    public boolean signUp(final UserRequest request) {
        User user = request.toEntity();
        // TODO 기존 사용자 조회 (중복 이메일 확인)
        // TODO USER 엔티티 저장
        // TODO - 1 : 비밀번호 저장 전 암호화
        return this.userDao.save(user);
    }
}
