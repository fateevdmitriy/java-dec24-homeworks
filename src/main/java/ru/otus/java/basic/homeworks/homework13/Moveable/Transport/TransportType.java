package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Human;

public enum TransportType {
    CAR("автомобиль",3),
    ALLTERRAIN("внедорожник",4),
    HORSE("лошадь",2),
    BYCICLE("велосипед", 0);

    private String name;
    private int consumption;
    
    TransportType(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public int getConsumption() {
        return consumption;
    }
}
