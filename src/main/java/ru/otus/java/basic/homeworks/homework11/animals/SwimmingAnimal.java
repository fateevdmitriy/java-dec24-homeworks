package ru.otus.java.basic.homeworks.homework11.animals;

public abstract class SwimmingAnimal extends Animal {
    private int swimSpeed;
    private int swimCost;

    public int getSwimSpeed() {
        return swimSpeed;
    }
    
    public SwimmingAnimal(String name, int endurance, int runSpeed, int swimSpeed, int swimCost) {
        super(name, endurance, runSpeed);
        this.swimSpeed = swimSpeed;
        this.swimCost = swimCost;
    }

    public int swim(int distance) {
        int endur = getEndurance();
        endur -= distance * swimCost;
        if (endur >= 0) {
            return distance / swimSpeed;
        }
        setEndurance(0);
        return -1;
    }
}
