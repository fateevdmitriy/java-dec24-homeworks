package ru.otus.java.basic.homeworks.homework11;

abstract class SwimmingAnimal extends Animal {
    int swimSpeed;
    int swimCost;

    SwimmingAnimal(String name, int endurance, int runSpeed, int swimSpeed, int swimCost) {
        super(name, endurance, runSpeed);
        this.swimSpeed = swimSpeed;
        this.swimCost = swimCost;
    }

    int swim(int distance) {
        endurance -= distance * swimCost;
        if (endurance >= 0) {
            return distance / swimSpeed;
        }
        endurance = 0;
        return -1;
    }
}
