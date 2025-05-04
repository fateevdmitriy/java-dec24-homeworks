package ru.otus.chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAuthenticationProviderImpl implements DatabaseAuthenticationProvider {

    private static final String USERS_QUERY = "select * from users";
    private static final String USERS_ROLES_QUERY =
                    "select r.id, r.name, r.privileged from roles r " +
                    "join users_to_roles ur on r.id = ur.role_id " +
                    "where user_id = ?";
    private static final String IS_ADMIN_QUERY =
                    "select count(1) from roles r" +
                    "join users_to_roles ur on r.id = ur.role_id" +
                    "where user_id = ? and r.privileged = true";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/otus-db";
    private final Connection connection;

    public DatabaseAuthenticationProviderImpl() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, "admin", "password");
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(USERS_QUERY)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString(2);
                    String email = rs.getString(3);
                    String login = rs.getString(4);
                    String password = rs.getString(5);
                    User newUserByQuery = new User(id, username, email, login, password);
                    allUsers.add(newUserByQuery);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement ps = connection.prepareStatement(USERS_ROLES_QUERY)) {
            for (User currentUser : allUsers) {
                ps.setInt(1, currentUser.getId());
                List<Role> roleUserByQuery = new ArrayList<>();
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        boolean privileged = rs.getBoolean(3);
                        Role currentRole = new Role(id, name, privileged);
                        roleUserByQuery.add(currentRole);
                    }
                    currentUser.setRoles(roleUserByQuery);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    @Override
    public boolean isAdmin(int userId) {
        int flag = 0;
        try (PreparedStatement ps = connection.prepareStatement(IS_ADMIN_QUERY)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag > 0;
    }

}
