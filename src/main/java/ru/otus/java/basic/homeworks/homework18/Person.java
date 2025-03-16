package ru.otus.java.basic.homeworks.homework18;

public class Person {
    private final Long id;
    private final String name;
    private final Position position;
    
    public Person(Long id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Long getId() { return id; }
    
    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
