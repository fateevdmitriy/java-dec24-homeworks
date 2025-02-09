package ru.otus.java.basic.homeworks.homework11;

public class Cat extends Animal {
    public Cat(String name, int endurance, int runSpeed) {
        super(name, endurance, runSpeed);
    }

    @Override
    public int run(int runDistance) {
        int time = super.run(runDistance);
        if (time >= 0) {
            System.out.println("Кот " + name + " пробежал дистанцию " + runDistance + " м. за " + time + " сек.");
        } else {
            System.out.println("Выносливости кота " + name + " не хватило, он устал и не побежал.");
        }
        return time;
    }

    @Override
    public void info() {
        System.out.println("Инфо: кот с именем " + name + ", скорость бега " + runSpeed + " м/c, остаток выносливости " + endurance +
                " у.е.");
    }
}
