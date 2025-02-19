package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Human;
import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;
import ru.otus.java.basic.homeworks.homework13.Moveable.Moving;

public abstract class Transport implements Moving {
    TransportType type;
    int energy;
    int consumption;
    Human driver;

    public Transport(TransportType type, int energy) {
        this.type = type;
        this.energy = energy;
        this.consumption = type.getConsumption() > 0 ? type.getConsumption() : Human.WALK_COST;
    }

    public void setDriver(Human driver) {
        this.driver = driver;
    }

    public TransportType getType() {
        return type;
    }

    boolean isAllowedLocality(Locality locality, Locality[] forbiddenLocalities) {
        for (Locality loc : forbiddenLocalities) {
            if (loc.equals(locality)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        System.out.println("Транспорт " + type.getName() + " начал передвигаться по местности " + locality.getName() + " на расстояние " + distance + " м.");
        if (driver == null) {
            System.out.println("Передвижение транспорта не выполнено, не двигается без водителя.");
            return false;
        }
        energy -= distance * consumption;
        if (energy >= 0) {
            System.out.println("Передвижение транспорта успешно выполнено.");
            return true;
        } else {
            System.out.println("Передвижение не выполнено, не хватило ресурсов.");
            energy = 0;
            return false;
        }
    }
}

