package ru.otus.java.basic.homeworks.homework13.Moveable;

import ru.otus.java.basic.homeworks.homework13.Moveable.Transport.Transport;

public class Human implements Moving {
    public static final int WALK_COST = 1;
    public static final String RESOURCE = "сил";
    String name;
    int energy;
    Transport transport;

    public Human(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void take(Transport transport) {
        this.transport = transport;
        transport.setDriver(this);
        System.out.println("Водитель " + name + " сел на транспорт " + transport.getType().getName() + ".");
    }

    public void getOut(Transport transport) {
        this.transport = null;
        transport.removeDriver();
        System.out.println("Водитель " + name + " покинул транспорт " + transport.getType().getName() + ".");
    }

    public boolean onTransport() {
        return transport != null;
    }

    public boolean expendEnergy(int distance) {
        energy -= distance * WALK_COST;
        if (energy >= 0) {
            return true;
        } else {
            energy = 0;
            return false;
        }
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (onTransport()) {
            return transport.move(distance, locality);
        } else {
            System.out.println(name + " двигается пешком по местности " + locality.getType() + " на расстояние " + distance + " км.");
            if (expendEnergy(distance)) {
                System.out.println("Перемещение пешком успешно выполнено. Осталось " + RESOURCE + " " + energy + ".");
                return true;
            } else {
                System.out.println("Перемещение пешком не завершено, не хватило " + RESOURCE + ".");
                return false;
            }
        }
    }

    public void info() {
        System.out.println("Инфо: человек с именем " + name + ", запас " + RESOURCE + " " + energy + ", расход " + RESOURCE + " на км. " +
                WALK_COST + ", способ перемещения: " + (onTransport() ? transport.getType().getName() : "пешком") + ".");
    }
}
