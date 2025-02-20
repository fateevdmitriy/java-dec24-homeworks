package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.Moveable.Human;
import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;
import ru.otus.java.basic.homeworks.homework13.Moveable.Transport.*;

public class HomeWork {
    public static void main(String[] args) {
        Human man1 = new Human("Антон", 1000);
        Human man2 = new Human("Мария", 900);
        Car car1 = new Car(200);
        AllTerrainVehicle vehicle1 = new AllTerrainVehicle(400);
        Horse horse1 = new Horse(1000);
        Bycicle bycicle1 = new Bycicle();

        System.out.println();
        man1.info();
        man1.move(400, Locality.FOREST);
        System.out.println();
        man1.info();
        car1.info();
        car1.move(10, Locality.PLAIN);
        man1.take(car1);
        car1.move(20, Locality.SWAMP);
        car1.move(20, Locality.FOREST);
        car1.move(20, Locality.PLAIN);
        car1.move(50, Locality.PLAIN);
        car1.info();
        man1.getOut(car1);
        car1.info();
        man1.info();
        System.out.println();
        man2.info();
        vehicle1.info();
        vehicle1.move(10, Locality.SWAMP);
        man2.take(vehicle1);
        man2.info();
        vehicle1.move(20, Locality.SWAMP);
        vehicle1.move(30, Locality.FOREST);
        vehicle1.move(50, Locality.PLAIN);
        vehicle1.info();
        man2.getOut(vehicle1);
        vehicle1.info();
        man2.move(500, Locality.PLAIN);
        man2.info();
        System.out.println();
        horse1.info();
        horse1.move(400, Locality.PLAIN);
        man2.take(horse1);
        man2.info();
        horse1.move(100, Locality.SWAMP);
        horse1.move(150, Locality.FOREST);
        horse1.move(250, Locality.PLAIN);
        horse1.info();
        man2.getOut(horse1);
        man2.info();
        System.out.println();
        man1.info();
        bycicle1.info();
        bycicle1.move(100, Locality.PLAIN);
        man1.take(bycicle1);
        man1.info();
        bycicle1.info();
        bycicle1.move(100, Locality.SWAMP);
        bycicle1.move(200, Locality.FOREST);
        bycicle1.move(300, Locality.PLAIN);
        bycicle1.info();
        man1.getOut(bycicle1);
        man1.info();
        man1.move(100, Locality.SWAMP);
        man1.info();
    }
}
