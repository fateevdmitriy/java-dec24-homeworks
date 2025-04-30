package main.java.ru.otus.java.basic.homeworks.homework27;

import main.java.ru.otus.java.basic.homeworks.homework27.boxes.Box;
import main.java.ru.otus.java.basic.homeworks.homework27.fruits.Apple;
import main.java.ru.otus.java.basic.homeworks.homework27.fruits.Fruit;
import main.java.ru.otus.java.basic.homeworks.homework27.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit("Fruit_1", 1.9f);
        Fruit fruit2 = new Fruit("Fruit_2", 2.3f);

        Apple apple1 = new Apple("Apple_1", 1.1f);
        Apple apple2 = new Apple("Apple_2", 1.2f);
        Apple apple3 = new Apple("Apple_3", 1.3f);
        Apple apple4 = new Apple("Apple_4", 1.4f);
        Apple apple5 = new Apple("Apple_5", 1.5f);

        Orange orange1 = new Orange("Orange_1", 1.6f);
        Orange orange2 = new Orange("Orange_2", 1.1f);
        Orange orange3 = new Orange("Orange_3", 0.9f);

        System.out.print(System.lineSeparator());
        
        Box<Fruit> fruitsBox1 = new Box<>("FruitsBox_1");
        fruitsBox1.add(fruit1);
        fruitsBox1.add(fruit2);
        System.out.println("Коробка " + fruitsBox1.getName() + ", Вес: " + fruitsBox1.weight() + ", Содержит:  " + fruitsBox1.getObjectsToString());

        ArrayList<Apple> apples1 = new ArrayList<>(Arrays.asList(apple1, apple2, apple3));
        Box<Apple> appleBox1 = new Box<>("AppleBox_1", apples1);
        System.out.println("Коробка " + appleBox1.getName() + ", Вес: " + appleBox1.weight() + ", Содержит:  " + appleBox1.getObjectsToString());

        ArrayList<Apple> apples2 = new ArrayList<>(Arrays.asList(apple3, apple4, apple5));
        Box<Apple> appleBox2 = new Box<>("AppleBox_2", apples2);
        System.out.println("Коробка " + appleBox2.getName() + ", Вес: " + appleBox2.weight() + ", Содержит:  " + appleBox2.getObjectsToString());

        ArrayList<Orange> oranges1 = new ArrayList<>(Arrays.asList(orange1, orange2, orange3));
        Box<Orange> orangeBox1 = new Box<>("OrangeBox_1", oranges1);
        System.out.println("Коробка " + orangeBox1.getName() + ", Вес: " + orangeBox1.weight() + ", Содержит:  " + orangeBox1.getObjectsToString());
        
        System.out.println(System.lineSeparator() + "Сравнение веса коробок:");
        System.out.println("appleBox1 vs orangeBox1: " + appleBox1.compare(orangeBox1));
        System.out.println("appleBox2 vs orangeBox1: " + appleBox2.compare(orangeBox1));
        System.out.println("appleBox2 vs fruitsBox1: " + appleBox2.compare(fruitsBox1));
        System.out.println("orangeBox1 vs fruitsBox1: " + orangeBox1.compare(fruitsBox1));

        System.out.println(System.lineSeparator() + "Пересыпание фруктов:");
        System.out.println("Из коробки " + appleBox1.getName() + ", содержание до: " + appleBox1.getObjectsToString());
        System.out.println("В коробку " + appleBox2.getName() + " содержание до: " + appleBox2.getObjectsToString());
        appleBox1.transferToBox(appleBox2);
        System.out.println("Из коробки " + appleBox1.getName() + ", содержание после: " + appleBox1.getObjectsToString());
        System.out.println("В коробку " + appleBox2.getName() + ", содержание после: " + appleBox2.getObjectsToString());
        
        System.out.println("Из коробки " + orangeBox1.getName() + ", содержание до: " + orangeBox1.getObjectsToString());
        System.out.println("В коробку " + fruitsBox1.getName() + ", содержание до: " + fruitsBox1.getObjectsToString());
        orangeBox1.transferToBox(fruitsBox1);
        System.out.println("Из коробки " + orangeBox1.getName() + ", содержание после: " + orangeBox1.getObjectsToString());
        System.out.println("В коробку " + fruitsBox1.getName() + ", содержание после: " + fruitsBox1.getObjectsToString());
    }
}
