package ru.otus.chat;

public class Role {

    private int id;
    private String name;
    private boolean privileged;

    public Role() {}

    public Role(int id, String name, boolean privileged) {
        this.id = id;
        this.name = name;
        this.privileged = privileged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "privileged=" + privileged +
                '}';
    }

}
