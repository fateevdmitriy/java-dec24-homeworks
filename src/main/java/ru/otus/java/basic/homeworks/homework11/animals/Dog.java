package ru.otus.java.basic.homeworks.homework11.animals;

public class Dog extends SwimmingAnimal {
    private static final int SWIM_COST = 2;

    public Dog(String name, int endurance, int runSpeed, int swimSpeed) {
        super(name, endurance, runSpeed, swimSpeed, SWIM_COST);
    }
    
    public void runWithCheck(int runDistance) {
        System.out.println("Собака " + name + " побежала дистанцию " + runDistance + " м...");
        int runTime = run(runDistance);
        if (runTime >= 0) {
            System.out.println("Собака " + name + " пробежала за " + runTime + " сек.");
        } else {
            System.out.println("Выносливости собаки " + name + " не хватило, она устала и не добежала.");
        }
    }
    
    public void swimWithCheck(int swimDistance) {
        System.out.println("Собака " + name + " поплыла дистанцию " + swimDistance + " м...");
        int swimTime = swim(swimDistance);
        if (swimTime >= 0) {
            System.out.println("Собака " + name + " проплыла за " + swimTime + " сек.");
        } else {
            System.out.println("Выносливости собаки " + name + " не хватило, она устала и не доплыла.");
        }
    }

    @Override
    public void info() {
        System.out.println("Инфо: собака " + name + ", выносливость " + endurance + " ед., скорость бега " + runSpeed + " м/с, " +
                "скорость плавания " + swimSpeed + " м/c, затраты на бег " + RUN_COST + " ед/м., затраты на плавание " + SWIM_COST + 
                " ед/м.");         
    }
}
