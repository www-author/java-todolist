package com.mtvs.todolist.domain.todolist.dto.response;

import com.mtvs.todolist.domain.todolist.model.TodoList;

public class TodoListResponse {
    private int id;
    private String content;
    private int userId;
    private boolean isCompleted;

    public TodoListResponse(final TodoList todoList) {
        this.id = todoList.getId();
        this.content = todoList.getContent();
        this.userId = todoList.getUserId();
        this.isCompleted = todoList.getIsCompleted();
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

    public boolean isCompleted() {
        return isCompleted;
    }
}
