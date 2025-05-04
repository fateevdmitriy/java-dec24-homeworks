package ru.otus.chat;

import java.util.List;

public interface DatabaseAuthenticationProvider {

    void initialize();

    boolean isUserInAdminRole(int userId);

    boolean authenticate(ClientHandler clientHandler, String login, String password);

}
