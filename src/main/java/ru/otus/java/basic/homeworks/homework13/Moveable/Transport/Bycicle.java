package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;

public class Bycicle extends Transport {
    private static Locality[] forbiddenLocalitiesArr = {Locality.SWAMP};

    public Bycicle(int energy) {
        super(TransportType.BYCICLE, energy);
    }
    
    public boolean tryMove(int distance, Locality locality) {
        if (isAllowedLocality(locality, forbiddenLocalitiesArr)) {
            return super.move(distance, locality);
        }
        System.out.println("Транспорт " + type.getName() + " не может передвигаться по типу местности." + locality.getName());
        return false;
    }
}
