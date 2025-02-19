package ru.otus.java.basic.homeworks.homework13.Moveable;

public enum Locality {
    FOREST("густой лес"),
    PLAIN("равнина"),
    SWAMP("болото");

    private String name;

    Locality(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    
}
