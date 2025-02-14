package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class SwimmingAnimal extends Animal {
    int swimSpeed;
    int swimCost;
    
    public SwimmingAnimal(String name, int endurance, int runSpeed, int swimSpeed, int swimCost) {
        super(name, endurance, runSpeed);
        this.swimSpeed = swimSpeed;
        this.swimCost = swimCost;
    }

    public int swim(int distance) {
        endurance -= distance * swimCost;
        if (endurance >= 0) {
            return distance / swimSpeed;
        }
        endurance = 0;
        return -1;
    }
}
