package ru.otus.java.basic.homeworks.homework13.moveable;

import ru.otus.java.basic.homeworks.homework13.moveable.transport.Transport;

public class Human implements Moving {
    public static final int WALK_COST = 1;
    public static final String RESOURCE = "сил";
    private final String name;
    private int energy;
    private Transport transport;

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
    
    public boolean onTransport() {
        return transport != null;
    }
    
    public void take(Transport transport) {
        if (onTransport()) {
            getOut();
        }
        this.transport = transport;
        transport.setDriver(this);
        System.out.println(name + " сел(а) на транспорт " + transport.getType().getName() + ".");
    }

    public void getOut() {
        if (onTransport()) {
            transport.removeDriver();
            System.out.println("Водитель " + name + " покинул транспорт " + transport.getType().getName() + ".");
            transport = null;             
        } else {
            System.out.println(name + " не находится в транспорте и поэтому не может его покинуть.");
        }
    }
    
    public boolean expendEnergy(int distance) {
        energy -= distance * WALK_COST;
        if (energy >= 0) {
            return true;
        } 
        energy = 0;
        return false;
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
