package ru.otus.java.basic.homeworks.homework13.moveable.transport;

import ru.otus.java.basic.homeworks.homework13.moveable.Moving;
import ru.otus.java.basic.homeworks.homework13.moveable.Locality;
import ru.otus.java.basic.homeworks.homework13.moveable.Human;

public abstract class Transport implements Moving {
    TransportType type;
    int energy;
    Human driver;

    public Transport(TransportType type) {
        this.type = type;
    }

    public Transport(TransportType type, int energy) {
        this.type = type;
        this.energy = energy;
    }

    public TransportType getType() {
        return type;
    }

    public boolean hasDriver() {
        return this.driver != null;
    }

    public void setDriver(Human driver) {
        this.driver = driver;
    }

    public void removeDriver() {
        if (hasDriver()) {
            this.driver = null;
        }
    }

    public boolean burnEnergy(int distance) {
        energy -= distance * type.getConsumption();
        if (energy >= 0) {
            return true;
        } else {
            energy = 0;
            return false;
        }
    }
    
    boolean isForbiddenLocality(Locality locality) {
        for (Locality loc : type.getForbiddenLocalities()) {
            if (loc == locality) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        System.out.println("Транспорт " + type.getName() + (hasDriver() ? " под управлением " + driver.getName() : " без водителя") +
                " получил команду двигаться по местности " + locality.getType() + " на расстояние " + distance + " км.");
        if (isForbiddenLocality(locality)) {
            System.out.println("Транспорт " + type.getName() + " не может передвигаться по местности " + locality.getType() + ".");
            return false;
        }
        if (!hasDriver()) {
            System.out.println("Передвижение транспорта без водителя невозможно.");
            return false;
        }
        if (type.getConsumption() > 0) {
            if (burnEnergy(distance)) {
                System.out.println("Передвижение транспорта успешно выполнено, у него осталось " + type.getResource() + " " + energy + ".");
                return true;
            } else {
                System.out.println("Передвижение не завершено, не хватило " + type.getResource() + ".");
                return false;
            }
        } else if (type.getConsumption() == 0) {
            if (driver.expendEnergy(distance)) {
                System.out.println("Передвижение транспорта успешно выполнено силами водителя, у его водителя осталось " + Human.RESOURCE +
                        " " + driver.getEnergy() + ".");
                return true;
            } else {
                System.out.println("Передвижение не завершено, у его водителя не хватило " + Human.RESOURCE + ".");
                return false;
            }
        } else {
            System.out.println("Передвижение не выполнено, расход ресурсов на передвижение не может иметь отрицательное значение.");
            return false;
        }
    }

    public void info() {
        System.out.println("Инфо: транспорт " + type.getName() + (hasDriver() ? " под управлением " + driver.getName() : " без " +
                "водителя") + ", запас " + type.getResource() + " " + energy + ", расход " + type.getResource() + " на км. " + type.getConsumption() + ".");
    }
}