package com.mtvs.todolist.global.model;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

    public BaseEntity() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.isDeleted = false;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void onUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void onDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
