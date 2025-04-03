package com.mtvs.todolist.global.error;

public enum ErrorCode {
    INVALID_MENU("유효하지 않은 메뉴를 선택하였습니다."),
    USER_NAME_REQUIRED("이름은 필수 입력 항목입니다."),
    INVALID_PASSWORD("유효하지 않은 비밀번호입니다. 비밀번호는 최소 8자에서 최대 12자까지 설정할 수 있습니다."),
    NOT_MATCH_PASSWORD("비밀번호가 서로 일치하지 않습니다. 다시 입력해주세요."),
    INVALID_EMAIL("유효하지 않는 이메일 형식입니다."),
    USER_REGISTRATION_FAILED("사용자 등록에 실패하였습니다. 다시 시도해주세요."),
    TODO_LIST_REGISTRATION_FAILED("투두 리스트 등록에 실패하였습니다."),
    USER_NOT_FOUND("가입된 사용자 정보가 없습니다."),
    DUPLICATE_USER("이미 존재하는 사용자입니다."),
    TODO_LIST_UPDATE_COMPLETION_STATUS_FAILED("투두 리스트 완료 여부 변경에 실하였습니다."),
    TODO_LIST_DELETE_FAILED("투두 리스트 삭제에 실패하였습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
