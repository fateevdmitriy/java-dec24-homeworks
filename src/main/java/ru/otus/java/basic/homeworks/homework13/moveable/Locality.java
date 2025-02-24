package ru.otus.java.basic.homeworks.homework13.moveable;

public enum Locality {
    FOREST("густой лес"),
    PLAIN("равнина"),
    SWAMP("болото");

    private final String type;

    Locality(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
