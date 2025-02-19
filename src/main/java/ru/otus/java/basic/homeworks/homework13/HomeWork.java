package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.Moveable.Human;
import ru.otus.java.basic.homeworks.homework13.Moveable.Locality;
import ru.otus.java.basic.homeworks.homework13.Moveable.Transport.*;

public class HomeWork {
    
    public static void main(String[] args) {
        Human man1 = new Human("Антон", 1000);
        Car car1 = new Car(100);
        
        man1.info();
        man1.take(car1);
        man1.info();
        car1.tryMove(20, Locality.FOREST);
        car1.tryMove(20, Locality.PLAIN);
        man1.getOut(car1);
        man1.info();
    }
    
}
