package com.mtvs.todolist.domain.todolist.model;

import com.mtvs.todolist.global.model.BaseEntity;

public class TodoList extends BaseEntity {
    private int id;
    private String content;
    private int userId;
    private boolean isCompleted;

    private TodoList(
        final String content,
        final int userId
    ) {
        super();
        this.content = content;
        this.userId = userId;
    }

    private TodoList(
        int todolistId,
        boolean isCompleted,
        String content,
        int userId
    ) {
        this.id = todolistId;
        this.content = content;
        this.userId = userId;
        this.isCompleted = isCompleted;
    }

    public static TodoList of(
            final String content,
            final int userId
    ) {
        return new TodoList(content, userId);
    }

    public static TodoList of(
        final int todolistId,
        final boolean isCompleted,
        final String content,
        final int userId
    ) {
        return new TodoList(todolistId, isCompleted, content, userId);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }
}
