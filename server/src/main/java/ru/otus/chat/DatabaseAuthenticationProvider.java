package ru.otus.chat;

import java.util.List;

public interface DatabaseAuthenticationProvider {
    List<User> getAll();

    boolean isAdmin(int userId);
}
