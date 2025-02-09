package ru.otus.java.basic.homeworks.homework11;

public class HomeWork {
    public static void main(String[] args) {
        String catName1 = "Барсик";
        int catEndurance1 = 500;
        int catRunSpeed1 = 5;
        
        String dogName1 = "Рэкс";
        int dogEndurance1 = 1000;
        int dogRunSpeed1 = 6;
        int dogSwimSpeed1 = 4;

        String horseName1 = "Буран";
        int horseEndurance1 = 2000;
        int horseRunSpeed1 = 10;
        int horseSwimSpeed1 = 3;
        
        int runDistance = 500;
        int swimDistance = 300;
        
        Cat cat1 = new Cat(catName1, catEndurance1, catRunSpeed1);
        cat1.info();
        cat1.run(runDistance);
        cat1.info();        
        
        Dog dog1 = new Dog(dogName1, dogEndurance1, dogRunSpeed1, dogSwimSpeed1);
        dog1.info();
        dog1.run(runDistance);
        dog1.info();
        dog1.swim(swimDistance);
        dog1.info();

        Horse horse1 = new Horse(horseName1 , horseEndurance1, horseRunSpeed1, horseSwimSpeed1);
        horse1.info();
        horse1.run(runDistance);
        horse1.info();
        horse1.swim(swimDistance);
        horse1.info();
    }
}
