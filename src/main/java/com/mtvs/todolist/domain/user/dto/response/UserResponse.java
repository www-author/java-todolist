package com.mtvs.todolist.domain.user.dto.response;

import com.mtvs.todolist.domain.user.model.User;

public record UserResponse(
    int id,
    String email,
    String name,
    boolean deleted

) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.isDeleted()
        );
    }
}
