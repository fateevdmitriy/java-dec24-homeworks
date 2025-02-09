package ru.otus.java.basic.homeworks.homework11;

public class Horse extends SwimmingAnimal {
    static final int horseSwimCost = 4;

    public Horse(String name, int endurance, int runSpeed, int swimSpeed) {
        super(name, endurance, runSpeed, swimSpeed, horseSwimCost);
    }

    @Override
    public int run(int runDistance) {
        int time = super.run(runDistance);
        if (time > 0) {
            System.out.println("Лошадь " + name + " пробежала дистанцию " + runDistance + " м. за " + time + " сек.");
        } else {
            System.out.println("Выносливости лошади " + name + " не хватило, она устала и не побежала.");
        }
        return time;
    }

    @Override
    public int swim(int swimDistance) {
        int time = super.swim(swimDistance);
        if (time > 0) {
            System.out.println("Лошадь " + name + " проплыла дистанцию " + swimDistance + " м. за " + time + " сек.");
        } else {
            System.out.println("Выносливости лошади " + name + " не хватило, она устала и не поплыла.");
        }
        return time;
    }

    @Override
    public void info() {
        System.out.println("Инфо: лошаддь по кличке " + name + ", скорость бега " + runSpeed + " м/с, скорость плавания " + swimSpeed +
                " м/c, остаток выносливости " + endurance + " у.е.");
    }
}
