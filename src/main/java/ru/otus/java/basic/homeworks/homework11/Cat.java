package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.animals.Animal;

public class Cat extends Animal {
    public Cat(String name, int endurance, int runSpeed) {
        super(name, endurance, runSpeed);
    }

    public void runWithCheck(int runDistance) {
        System.out.println("Кот " + getName() + " побежал дистанцию " + runDistance + " м...");
        int runTime = run(runDistance);
        if (runTime >= 0) {
            System.out.println("Кот " + getName() + " пробежал за " + runTime + " сек.");
        } else {
            System.out.println("Выносливости кота " + getName() + " не хватило, он устал и не добежал.");
        }
    }

    @Override
    public void info() {
        System.out.println("Инфо: кот " + getName() + ", выносливость " + getEndurance() + " ед., скорость бега " + getRunSpeed() + " м/c," +
                " затраты на бег " + RUN_COST + " ед/м.");
    }
}
