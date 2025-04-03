package com.mtvs.todolist.domain.user.exception;

import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.exception.BusinessException;

public class DuplicateUserException extends BusinessException {
    public DuplicateUserException() {
        super(ErrorCode.DUPLICATE_USER);
    }
}
