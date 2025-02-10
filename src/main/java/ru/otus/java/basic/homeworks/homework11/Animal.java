package ru.otus.java.basic.homeworks.homework11;

abstract class Animal {
    static final int runCost = 1;
    String name;
    int endurance;
    int runSpeed;

    Animal(String name, int endurance, int runSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

   int run(int distance) {
        endurance -= distance * runCost;
        if (endurance >= 0) {
            return distance / runSpeed;
        }
        endurance = 0;
        return -1;
    }

    abstract void info();
}

