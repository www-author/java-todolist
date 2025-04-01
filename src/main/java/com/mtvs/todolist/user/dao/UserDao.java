package com.mtvs.todolist.user.dao;

import com.mtvs.todolist.global.config.JDBCConnection;
import com.mtvs.todolist.global.error.ErrorCode;
import com.mtvs.todolist.global.util.Log;
import com.mtvs.todolist.global.util.SqlHelper;
import com.mtvs.todolist.user.model.User;
import org.slf4j.event.Level;

import java.sql.*;
import java.util.Optional;

public class UserDao {
    private final Connection connection;

    public UserDao() throws SQLException {
        this.connection = JDBCConnection.getConnection();
    }

    public Optional<User> findByEmail(final String email) {
        String query = SqlHelper.getQuery("findUserByEmail");
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(User.of(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
        return Optional.empty();
    }

    public boolean existByEmail(final String email) {
        boolean isAuthenticated = false;
        String query = SqlHelper.getQuery("existsByEmail");

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isAuthenticated =  rs.getBoolean(1);
            }
        } catch (SQLException e) {
            Log.record(Level.ERROR, e.getMessage());
        }
        return isAuthenticated;
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
