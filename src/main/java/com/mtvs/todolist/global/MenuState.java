package com.mtvs.todolist.global;

import com.mtvs.todolist.global.error.ErrorCode;

import java.util.Arrays;

public enum MenuState {
    SIGN_UP(1),
    LOGIN(2),
    EXIT(3)
    ;
    private final int order;

    MenuState(final int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public static MenuState getMenu(final int order) {
        return Arrays.stream(MenuState.values())
                .filter(x -> x.getOrder() == order)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage()));
    }
}
