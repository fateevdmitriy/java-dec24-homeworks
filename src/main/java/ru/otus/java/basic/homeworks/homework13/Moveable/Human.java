package ru.otus.java.basic.homeworks.homework13.Moveable;

import ru.otus.java.basic.homeworks.homework13.Moveable.Transport.Transport;

public class Human implements Moving {
    public static final int WALK_COST = 1;
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
    
    public void take(Transport transport) {
        this.transport = transport;
        transport.setDriver(this);
        System.out.println("Водитель " + name + " сел в " + transport.getType().getName());
    }

    public void getOut(Transport transport) {
        this.transport = null;
        transport.setDriver(null);
        System.out.println("Водитель " + name + " покинул " + transport.getType().getName());
    }

    public boolean onTransport() {
        return transport != null;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (onTransport()) {
            return transport.move(distance, locality);
        } else {
            System.out.println("Человек с именем '" + name + "' начал двигаться пешком на расстояние "+distance+" м. по местности " + locality.getName());
            energy -= distance * WALK_COST;
            if (energy >= 0) {
                System.out.println("Перемещение пешком на растояние " + distance + " м. успешно выполнено. Осталось сил " + energy + ".");
                return true;
            } else {
                System.out.println("Перемещение пешком на растояние " + distance + " м. не выполнено, не хватило сил.");
                energy = 0;
                return false;
            }
        }
    }

    public void info() {
        System.out.println("Человек с именем '" + name + "', запасом сил: " + energy + ", способ перемещения: " +
                (onTransport() ? transport.getType().getName() : "пешком"));
    }
}
