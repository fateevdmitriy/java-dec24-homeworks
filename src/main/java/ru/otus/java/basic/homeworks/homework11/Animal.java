package ru.otus.java.basic.homeworks.homework11;

public abstract class Animal {
    static final int runCost = 1;
    String name;
    int endurance;
    int runSpeed;

    public Animal(String name, int endurance, int runSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    public int run(int distance) {
        endurance -= distance * runCost;
        if (endurance >= 0) {
            return distance / runSpeed;
        }
        return -1;
    }

    public abstract void info();
}

