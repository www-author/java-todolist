package com.mtvs.todolist.global.error;

public enum ErrorCode {
    INVALID_MENU("유효하지 않은 메뉴를 선택하였습니다.")
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
