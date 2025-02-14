package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class Animal {
    protected static final int RUN_COST = 1;
    String name;
    int endurance;
    int runSpeed;
    
    public Animal(String name, int endurance, int runSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

   public int run(int distance) {
        endurance -= distance * RUN_COST;
        if (endurance >= 0) {
            return distance / runSpeed;
        }
        endurance = 0;
        return -1;
    }

    public abstract void info();
}

