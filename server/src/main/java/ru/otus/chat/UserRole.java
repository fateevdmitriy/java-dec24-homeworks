package ru.otus.chat;

public enum UserRole {
    ADMINISTRATOR(true),
    USER(false);
    
    private final boolean privileged;

    UserRole(boolean privileged) {
        this.privileged = privileged;
    }

    public boolean isAdmin() {
        return privileged;
    }
}
