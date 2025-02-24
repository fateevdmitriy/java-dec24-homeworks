package ru.otus.java.basic.homeworks.homework13.moveable.transport;

import ru.otus.java.basic.homeworks.homework13.moveable.Locality;

public enum TransportType {
    CAR("автомобиль", "бензина", 3, new Locality[]{Locality.FOREST, Locality.SWAMP}),
    ALLTERRAIN("вездеход", "бензина", 4),
    HORSE("лошадь", "сил", 2, new Locality[]{Locality.SWAMP}),
    BYCICLE("велосипед", "сил", 0, new Locality[]{Locality.SWAMP});

    private final String name;
    private final String resource;
    private final int consumption;
    private final Locality[] forbiddenLocalities;

    TransportType(String name, String resource, int consumption) {
        this.name = name;
        this.resource = resource;
        this.consumption = consumption;
        this.forbiddenLocalities = new Locality[]{};
    }

    TransportType(String name, String resource, int consumption, Locality[] forbiddenLocalities) {
        this.name = name;
        this.resource = resource;
        this.consumption = consumption;
        this.forbiddenLocalities = forbiddenLocalities;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public int getConsumption() {
        return consumption;
    }

    public Locality[] getForbiddenLocalities() {
        return forbiddenLocalities;
    }
}
