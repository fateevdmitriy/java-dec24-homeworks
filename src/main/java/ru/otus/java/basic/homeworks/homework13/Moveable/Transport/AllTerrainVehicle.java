package ru.otus.java.basic.homeworks.homework13.Moveable.Transport;

import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;

public class AllTerrainVehicle extends Transport {
    //static final int MOVE_COST = 4;
    
    public AllTerrainVehicle(int fuel) {
        super(TransportType.ALLTERRAIN, fuel);
    }
    
    public boolean tryMove(int distance, Locality locality) {
        return super.move(distance, locality);
    }
}
