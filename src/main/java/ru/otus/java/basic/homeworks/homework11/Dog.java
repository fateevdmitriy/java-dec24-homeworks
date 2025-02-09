package ru.otus.java.basic.homeworks.homework11;

public class Dog extends SwimmingAnimal {
    static final int dogSwimCost = 2;

    public Dog(String name, int endurance, int runSpeed, int swimSpeed) {
        super(name, endurance, runSpeed, swimSpeed, dogSwimCost);
    }

    @Override
    public int run(int runDistance) {
        int time = super.run(runDistance);
        if (time >= 0) {
            System.out.println("Собака " + name + " пробежала дистанцию " + runDistance + " м. за " + time + " сек.");
        } else {
            System.out.println("Выносливости собаки " + name + " не хватило, она устала и не побежала.");
        }
        return time;
    }

    @Override
    public int swim(int swimDistance) {
        int result = super.swim(swimDistance);
        if (result >= 0) {
            System.out.println("Собакен " + name + " проплыл дистанцию " + swimDistance + " м. за " + result + " сек.");
        } else {
            System.out.println("Выносливости собаки " + name + " не хватило, она устала и не поплыла.");
        }
        return result;
    }

    @Override
    public void info() {
        System.out.println("Инфо: собака по кличке " + name + ", скорость бега " + runSpeed + " м/с, скорость плавания " + swimSpeed + " " +
                "м/c, остаток выносливости " + endurance + " у.е.");
    }
}
