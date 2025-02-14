package ru.otus.java.basic.homeworks.homework11.animals;

public class Cat extends Animal {
    public Cat(String name, int endurance, int runSpeed) {
        super(name, endurance, runSpeed);
    }

    public void runWithCheck(int runDistance) {
        System.out.println("Кот " + name + " побежал дистанцию " + runDistance + " м...");
        int runTime = run(runDistance);
        if (runTime >= 0) {
            System.out.println("Кот " + name + " пробежал за " + runTime + " сек.");
        } else {
            System.out.println("Выносливости кота " + name + " не хватило, он устал и не добежал.");
        }
    }

    @Override
    public void info() {
        System.out.println("Инфо: кот " + name + ", выносливость " + endurance + " ед., скорость бега " + runSpeed + " м/c, затраты на " +
                "бег " + RUN_COST + " ед/м.");
    }
}
