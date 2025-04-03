package com.mtvs.todolist.domain.todolist.controller;

import com.mtvs.todolist.domain.todolist.dto.response.TodoListResponse;
import com.mtvs.todolist.domain.todolist.service.TodoListService;
import com.mtvs.todolist.domain.todolist.view.ToDoListView;
import com.mtvs.todolist.domain.user.dto.response.UserResponse;

import java.util.List;

public class TodoListController {
    private final ToDoListView toDoListView;
    private final TodoListService todoListService;

    private TodoListController() {
        this.toDoListView = ToDoListView.getInstance();
        this.todoListService = TodoListService.getInstance();
    }

    public static TodoListController getInstance()  {
        return new TodoListController();
    }

    public void showMenu(final UserResponse response)  {
        toDoListView.showMenu(response);
    }

    public void updateCompletionStatus(final List<TodoListResponse> request) {
        todoListService.updateCompletionStatus(request);
    }

    public List<TodoListResponse> readTodoList(final int userId) {
        return todoListService.findAllByUserId(userId);
    }

    public void createTodoList(final int userId, final String content) {
        todoListService.createTodoList(userId, content);
    }

    public List<TodoListResponse> readTodoListByUserIdAndKeyword(final int userId, final String keyword) {
        return todoListService.findAllByUserIdAndKeyword(userId, keyword);
    }

    public void deleteTodoList(List<Integer> ids) {
         todoListService.deleteTodoList(ids);
    }
}
