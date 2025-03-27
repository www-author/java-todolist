package com.mtvs.todolist.global;

import com.mtvs.todolist.global.error.ErrorCode;

import java.util.Arrays;

public enum Menu {
    SIGN_UP(1),
    LOGIN(2),
    EXIT(3)
    ;
    private final int order;

    Menu(final int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public static Menu getMenu(final int order) {
        return Arrays.stream(Menu.values())
                .filter(x -> x.getOrder() == order)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_MENU.getMessage()));
    }
}
