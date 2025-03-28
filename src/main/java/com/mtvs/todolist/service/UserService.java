package com.mtvs.todolist.service;

import com.mtvs.todolist.dto.request.UserRequest;

public class UserService {
    public static UserService getInstance() {
        return new UserService();
    }

    public void signUp(final UserRequest request) {
        // TODO 일단, 각 입력 값들의 NULL 체크, 값 비교 (PW & CPW), 이메일 체크는 나중에 구현

        // 별일 없으면 디비 값 저장
    }
}
