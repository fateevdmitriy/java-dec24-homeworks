package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;

public class Car extends Transport {
    //static final int MOVE_COST = 3;
    private static Locality[] forbiddenLocalitiesArr = {Locality.FOREST, Locality.SWAMP};

    public Car(int fuel) {
        super(TransportType.CAR, fuel);
    }

    public boolean tryMove(int distance, Locality locality) {
        if (isAllowedLocality(locality, forbiddenLocalitiesArr)) {
            return super.move(distance, locality);
        }
        System.out.println("Транспорт " + type.getName() + " не может передвигаться по местности " + locality.getName());
        return false;
    }
}
