package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class Animal {
    protected static final int RUN_COST = 1;
    private String name;
    private int endurance;
    private int runSpeed;
    
    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

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

