package com.mtvs.todolist.domain.todolist.dao;

import com.mtvs.todolist.domain.todolist.dto.response.TodoListResponse;
import com.mtvs.todolist.domain.todolist.model.TodoList;
import com.mtvs.todolist.global.config.JDBCConnection;
import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.util.Log;
import com.mtvs.todolist.global.util.SqlHelper;
import org.slf4j.event.Level;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoListDao {
    public boolean create(final TodoList todoList) {
        String query = SqlHelper.getQuery("addTodoList");
        try (PreparedStatement ps = JDBCConnection.getConnection()
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, todoList.getContent());
            ps.setInt(2, todoList.getUserId());
            if (ps.executeUpdate() < 1) {
                throw new SQLException(ErrorCode.TODO_LIST_REGISTRATION_FAILED.getMessage());
            }
            return true;
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
        return false;
    }

    public List<TodoList> findAllByUserId(final int userId) {
        String query = SqlHelper.getQuery("findAllTodoListByUserId");
        return findAllBy(query, userId);
    }

    public List<TodoList> findAllByUserIdAndKeyword(final int userId, final String keyword) {
        String query = SqlHelper.getQuery("findAllByUserIdAndKeyword");
        return findAllBy(query, userId, keyword + "*");
    }

    private List<TodoList> findAllBy(String query, Object... params) {
        List<TodoList> todoList = new ArrayList<>();
        try (PreparedStatement ps = JDBCConnection.getConnection()
                .prepareStatement(query)) {
            setParameters(ps, params);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               todoList.add(
                       TodoList.of(
                           rs.getInt("todo_list_id"),
                           rs.getBoolean("is_completed"),
                           rs.getString("content"),
                           rs.getInt("user_id")
               ));
            }
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
        return todoList;
    }

    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]); // 자동으로 타입 설정
        }
    }

    public void updateCompletionStatus(List<TodoListResponse> request) {
        String query = SqlHelper.getQuery("updateCompletionStatus");
        try (PreparedStatement ps = JDBCConnection.getConnection()
                .prepareStatement(query)
        ) {
            for (TodoListResponse item : request) {
                ps.setBoolean(1, !item.isCompleted());
                ps.setInt(2, item.getId());
                if (ps.executeUpdate() < 1) {
                    throw new SQLException(ErrorCode.TODO_LIST_UPDATE_COMPLETION_STATUS_FAILED.getMessage());
                }
            }
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
    }

    public void deleteTodoList(final List<Integer> ids) {
        StringBuilder sb = new StringBuilder(SqlHelper.getQuery("deleteTodoList"));
        sb.append(String.join(",",Collections.nCopies(ids.size(), "?"))).append(")");

        try (PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sb.toString())) {
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i + 1, ids.get(i));
            }
            if (ps.executeUpdate() < 1) {
                throw new SQLException(ErrorCode.TODO_LIST_DELETE_FAILED.getMessage());
            }
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
    }
}
