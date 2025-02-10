package ru.otus.java.basic.homeworks.homework11;

public class Horse extends SwimmingAnimal {
    private static final int swimCost = 4;

    public Horse(String name, int endurance, int runSpeed, int swimSpeed) {
        super(name, endurance, runSpeed, swimSpeed, swimCost);
    }

    public void runWithCheck(int runDistance) {
        System.out.println("Лошадь " + name + " побежала дистанцию " + runDistance + " м...");
        int runTime = run(runDistance);
        if (runTime > 0) {
            System.out.println("Лошадь " + name + " пробежала за " + runTime + " сек.");
        } else {
            System.out.println("Выносливости лошади " + name + " не хватило, она устала и не добежала.");
        }
    }

    public void swimWithCheck(int swimDistance) {
        System.out.println("Лошадь " + name + " поплыла дистанцию " + swimDistance + " м...");
        int swimTime = swim(swimDistance);
        if (swimTime > 0) {
            System.out.println("Лошадь " + name + " проплыла за " + swimTime + " сек.");
        } else {
            System.out.println("Выносливости лошади " + name + " не хватило, она устала и не доплыла.");
        }
    }

    @Override
    public void info() {
        System.out.println("Инфо: лошаддь " + name + ", выносливость " + endurance + " ед., скорость бега " + runSpeed + " м/с, скорость плавания " + swimSpeed + " м/c, затраты на бег " + runCost + " ед/м., затраты на плавание " + swimCost + " ед/м.");
    }
}
