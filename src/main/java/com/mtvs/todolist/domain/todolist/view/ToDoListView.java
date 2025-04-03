package com.mtvs.todolist.domain.todolist.view;

import com.mtvs.todolist.domain.todolist.controller.TodoListController;
import com.mtvs.todolist.domain.todolist.dto.response.TodoListResponse;
import com.mtvs.todolist.domain.user.controller.UserController;
import com.mtvs.todolist.domain.user.dto.response.UserResponse;
import com.mtvs.todolist.global.Menu;
import com.mtvs.todolist.global.MenuType;
import com.mtvs.todolist.global.Message;
import com.mtvs.todolist.global.util.Console;
import com.mtvs.todolist.global.util.TimeManager;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.mtvs.todolist.global.Menu.findByMenu;

public class ToDoListView {

    private ToDoListView(){
    }

    public static ToDoListView getInstance() {
        return new ToDoListView();
    }

    public void showMenu(final UserResponse response)  {
        System.out.println(Message.INTRO.makeMessage(StringUtils.EMPTY));
        System.out.printf("%s %s님\n", Message.SUCCESS_LOGIN.getMessage(), response.name());
        TodoListController.getInstance().readTodoList(response.id());
        chooseMenu(response);
    }

    private void chooseMenu(final UserResponse request) {
        printView(TodoListController.getInstance().readTodoList(request.id()));
        System.out.println(Message.TODO_LIST_MENU.getMessage());
        while (true) {
            switch (findMenu()) {
                case CREATE -> createTodoList(request);
                case TOGGLE -> updateCompletionStatus(request);
                case DELETE -> deleteTodoList(request);
                case LOGOUT -> UserController.getInstance().logout();
                default -> retryMenuSelection(request);
            }
        }
    }

    private Menu findMenu() {
        if (Console.isInvalidInt()){
            return findByMenu(Console.open().nextInt(), MenuType.TODO_LIST);
        }
        return Menu.DEFAULT;
    }

    private void retryMenuSelection(final UserResponse request) {
        System.out.flush();
        Console.reset();
        System.out.println(Message.INVALID_MENU.getMessage());
        TimeManager.delay(1L);
        showMenu(request);
    }

    private void deleteTodoList(final UserResponse request) {
        System.out.flush();
        Console.reset();
        TodoListController.getInstance().deleteTodoList(
                searchKeyword(request)
                        .stream()
                        .map(TodoListResponse::getId)
                        .toList()
        );
        TimeManager.delay(1L);
        showMenu(request);
    }

    private void updateCompletionStatus(final UserResponse request) {
        System.out.flush();
        Console.reset();
        TodoListController.getInstance().updateCompletionStatus(searchKeyword(request));
        chooseMenu(request); // 업데이트된 목록 출력
    }

    private static List<TodoListResponse> searchKeyword(UserResponse request) {
        System.out.println(Message.ENTER_SEARCH_KEYWORD.getMessage());
        String keyword = Console.open().nextLine().strip();
        return TodoListController.getInstance().readTodoListByUserIdAndKeyword(request.id(), keyword);
    }

    private void createTodoList(final UserResponse request) {
        System.out.flush();
        Console.reset();

        System.out.println(Message.REQUEST_TODO_INPUT.getMessage());

        TodoListController.getInstance().createTodoList(request.id(), Console.open().nextLine() + "\n");
        chooseMenu(request);
    }

    private void printView(final List<TodoListResponse> todoList) {
        for (TodoListResponse item : todoList) {
            System.out.printf(
                "%s %s",
                item.isCompleted() ? "✅" : "⬜",
                item.getContent()
            );
        }
    }

}
