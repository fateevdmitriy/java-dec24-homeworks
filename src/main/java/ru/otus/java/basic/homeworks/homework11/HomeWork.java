package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.animals.Cat;
import ru.otus.java.basic.homeworks.homework11.animals.Dog;
import ru.otus.java.basic.homeworks.homework11.animals.Horse;

public class HomeWork {
    public static void main(String[] args) {
        String catName1 = "Барсик";
        int catEndurance1 = 500;
        int catRunSpeed1 = 4;
        int catRunDistance1 = 400;
        
        String dogName1 = "Рэкс";
        int dogEndurance1 = 1000;
        int dogRunSpeed1 = 5;
        int dogRunDistance1 = 500;
        int dogSwimSpeed1 = 4;
        int dogSwimDistance1 = 200;

        String horseName1 = "Заря";
        int horseEndurance1 = 2000;
        int horseRunSpeed1 = 10;
        int horseRunDistance = 1000;
        int horseSwimSpeed1 = 3;
        int horseSwimDistance = 100;

        System.out.println();
        Cat cat1 = new Cat(catName1, catEndurance1, catRunSpeed1);
        cat1.info();
        cat1.runWithCheck(catRunDistance1);
        cat1.info();
        cat1.runWithCheck(catRunDistance1);
        cat1.info();

        System.out.println();   
        Dog dog1 = new Dog(dogName1, dogEndurance1, dogRunSpeed1, dogSwimSpeed1);
        dog1.info();
        dog1.runWithCheck(dogRunDistance1);
        dog1.info();
        dog1.swimWithCheck(dogSwimDistance1);
        dog1.info();
        dog1.runWithCheck(dogRunDistance1);
        dog1.info();
        
        System.out.println();
        Horse horse1 = new Horse(horseName1 , horseEndurance1, horseRunSpeed1, horseSwimSpeed1);
        horse1.info();
        horse1.runWithCheck(horseRunDistance);
        horse1.info();
        horse1.swimWithCheck(horseSwimDistance);
        horse1.info();
        horse1.runWithCheck(horseRunDistance);
        horse1.info();
    }
}
