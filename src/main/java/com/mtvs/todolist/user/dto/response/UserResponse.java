package com.mtvs.todolist.user.dto.response;

import com.mtvs.todolist.user.model.User;

public class UserResponse {
    private final String email;
    private final String name;
    private final boolean deleted;

    private UserResponse(
        String email,
        String name,
        boolean deleted
    ) {
        this.email = email;
        this.name = name;
        this.deleted = deleted;
    }

    public static UserResponse from(User user) {
        return new UserResponse(
            user.getEmail(),
            user.getName(),
            user.isDeleted()
        );
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
