package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;

public class Horse extends Transport {
    //private static final int MOVE_COST = 2;
    private static Locality[] forbiddenLocalitiesArr = {Locality.SWAMP};

    public Horse(int power) {
        super(TransportType.HORSE, power);
    }
    
    public boolean tryMove(int distance, Locality locality) {
        if (isAllowedLocality(locality, forbiddenLocalitiesArr)) {
            return super.move(distance, locality);
        }
        System.out.println("Транспорт " + type.getName() + " не может передвигаться по местности " + locality.getName());
        return false;
    }
}
