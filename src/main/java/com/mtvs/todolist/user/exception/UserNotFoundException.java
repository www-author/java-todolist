package com.mtvs.todolist.user.exception;

import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
