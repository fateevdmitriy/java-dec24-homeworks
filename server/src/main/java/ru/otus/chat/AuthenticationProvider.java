package ru.otus.chat;

public interface AuthenticationProvider {
    
    void initialize();
    
    UserRole getUserRoleByUsername(String username);
    
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    
    boolean registration(ClientHandler clientHandler, String login, String password, String username);
}
