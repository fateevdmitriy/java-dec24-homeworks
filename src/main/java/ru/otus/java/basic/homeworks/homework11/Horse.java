package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.animals.SwimmingAnimal;

public class Horse extends SwimmingAnimal {
    private static final int SWIM_COST = 4;

    public Horse(String name, int endurance, int runSpeed, int swimSpeed) {
        super(name, endurance, runSpeed, swimSpeed, SWIM_COST);
    }

    public void runWithCheck(int runDistance) {
        System.out.println("Лошадь " + getName() + " побежала дистанцию " + runDistance + " м...");
        int runTime = run(runDistance);
        if (runTime > 0) {
            System.out.println("Лошадь " + getName() + " пробежала за " + runTime + " сек.");
        } else {
            System.out.println("Выносливости лошади " + getName() + " не хватило, она устала и не добежала.");
        }
    }

    public void swimWithCheck(int swimDistance) {
        System.out.println("Лошадь " + getName() + " поплыла дистанцию " + swimDistance + " м...");
        int swimTime = swim(swimDistance);
        if (swimTime > 0) {
            System.out.println("Лошадь " + getName() + " проплыла за " + swimTime + " сек.");
        } else {
            System.out.println("Выносливости лошади " + getName() + " не хватило, она устала и не доплыла.");
        }
    }

    @Override
    public void info() {
        System.out.println("Инфо: лошаддь " + getName() + ", выносливость " + getEndurance() + " ед., скорость бега " + getRunSpeed() + " м/с, " +
                "скорость плавания " + getSwimSpeed() + " м/c, затраты на бег " + RUN_COST + " ед/м., затраты на плавание " + SWIM_COST + " " +
                "ед/м.");
    }
}
