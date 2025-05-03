package ru.otus.chat;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticationProvider implements AuthenticationProvider {
    
    private class User {
        private String login;
        private String password;
        private String username;
        private UserRole userRole;

        public User(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.userRole = UserRole.USER;
        }

        public User(String login, String password, String username, UserRole userRole) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.userRole = userRole;
        }
        
    }

    private Server server;
    private List<User> users;
    
    public InMemoryAuthenticationProvider(Server server) {
        this.server = server;
        this.users = new CopyOnWriteArrayList<>();
        fillUsersAccounts();
    }

    @Override
    public void initialize() {
        System.out.println("initialize InMemoryAuthenticationProvider");
    }

    @Override
    public UserRole getUserRoleByUsername(String username) {
        for (User user : users) {
            if (username.equalsIgnoreCase(user.username)) {
                return user.userRole;
            }
        }
        return null;
    }
    
    private void fillUsersAccounts() {
        this.users.add(new User("user1", "123", "user_1", UserRole.ADMINISTRATOR));
        this.users.add(new User("user2", "123", "user_2", UserRole.USER));
        this.users.add(new User("user3", "123", "user_3", UserRole.USER));
    } 
    
    private String getUsernameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.username;
            }
        }
        return null;
    }

    private boolean isLoginAlreadyExist(String login) {
        for (User user : users) {
            if (user.login.equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExist(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        System.out.println("---> authUsername: "+authUsername);
        
        if (authUsername == null) {
            clientHandler.sendMsg("Некорректный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Данная учетная запись уже занята");
            return false;
        }
        clientHandler.setUsername(authUsername);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);
        return true;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username) {
        if (login.trim().length() < 3 || password.trim().length() < 3 || username.trim().length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExist(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (isUsernameAlreadyExist(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }
        users.add(new User(login, password, username));
        clientHandler.setUsername(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }
}
