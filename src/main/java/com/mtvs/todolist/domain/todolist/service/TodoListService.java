package com.mtvs.todolist.domain.todolist.service;

import com.mtvs.todolist.domain.todolist.dao.TodoListDao;
import com.mtvs.todolist.domain.todolist.dto.response.TodoListResponse;
import com.mtvs.todolist.domain.todolist.model.TodoList;

import java.util.List;

public class TodoListService {
    private final TodoListDao todoListDao;

    private TodoListService() {
        this.todoListDao = new TodoListDao();
    }

    public static TodoListService getInstance() {
        return new TodoListService();
    }

    public void createTodoList(
            final int userId,
            final String content
    ) {
        todoListDao.create(TodoList.of(content, userId));
    }

    public List<TodoListResponse> findAllByUserId(final int userId) {
        return todoListDao.findAllByUserId(userId)
                .stream()
                .map(TodoListResponse::new)
                .toList();
    }

    public List<TodoListResponse> findAllByUserIdAndKeyword(int userId, String keyword) {
        return todoListDao.findAllByUserIdAndKeyword(userId, keyword)
                .stream()
                .map(TodoListResponse::new)
                .toList();
    }

    public void updateCompletionStatus(final List<TodoListResponse> request) {
        todoListDao.updateCompletionStatus(request);
    }

    public void deleteTodoList(List<Integer> ids) {
        todoListDao.deleteTodoList(ids);
    }
}
