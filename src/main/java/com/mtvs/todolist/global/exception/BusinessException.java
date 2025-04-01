package com.mtvs.todolist.global.exception;

import com.mtvs.todolist.global.error.ErrorCode;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
