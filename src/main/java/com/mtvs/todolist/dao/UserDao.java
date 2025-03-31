package com.mtvs.todolist.dao;

import com.mtvs.todolist.global.config.JDBCConnection;
import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.util.Log;
import com.mtvs.todolist.global.util.SqlHelper;
import com.mtvs.todolist.model.User;
import org.slf4j.event.Level;

import java.sql.*;

public class UserDao {
    private final Connection connection;

    public UserDao() throws SQLException {
        this.connection = JDBCConnection.getConnection();
    }

    public boolean save(final User user) {
        String query = SqlHelper.getQuery("addUser");
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setTimestamp(4, Timestamp.valueOf(user.getCreatedAt()));
            ps.setTimestamp(5, Timestamp.valueOf(user.getUpdatedAt()));
            ps.setBoolean(6, user.isDeleted());

            if (ps.executeUpdate() < 1) {
                throw new SQLException(ErrorCode.USER_REGISTRATION_FAILED.getMessage());
            }
            return true;
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
        return false;
    }
}
