package ru.otus.chat;

public interface AuthenticationProvider {
    
    void initialize();

    boolean isUserInAdminRole(String username);
    
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    
    boolean registration(ClientHandler clientHandler, String login, String password, String username);
}
