package com.mtvs.todolist.global;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Menu {
    SIGN_UP(MenuType.ROOT, 1),
    LOGIN(MenuType.ROOT, 2),
    EXIT(MenuType.ROOT, 3),
    CREATE(MenuType.TODO_LIST, 1),
    TOGGLE(MenuType.TODO_LIST, 2),
    DELETE(MenuType.TODO_LIST, 3),
    LOGOUT(MenuType.TODO_LIST, 4),
    BACK_TO_MENU(MenuType.TODO_LIST, 4),
    //RANKING(MenuType.TODO_LIST, 3),
    DEFAILT(MenuType.NONE, 99999)
    ;

    private final MenuType menuType;
    private final int order;

    Menu(
        final MenuType menuType,
        final int order
    ) {
        this.menuType = menuType;
        this.order = order;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public int getOrder() {
        return this.order;
    }

    public static Menu findByMenu(final int order, final MenuType type) {
        return findMenuByCondition(x -> x.menuType == type && x.getOrder() == order);
    }

    private static Menu findMenuByCondition(Predicate<Menu> condition) {
        return Arrays.stream(Menu.values())
                .filter(condition)
                .findFirst()
                .orElseGet(() -> Menu.DEFAILT);
    }
}
