package ru.otus.java.basic.homeworks.homework3;

public class FirstHomeWork {

    public static void main(String[] args) {
        greetings();
        checkSign(3,-5,2);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(33 , 15, true );

    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        String positiveSum = "Сумма положительная";
        String negativeSum = "Сумма отрицательная";
        if (a + b + c >= 0) {
            System.out.println(positiveSum);
        } else {
            System.out.println(negativeSum);
        }
    }

    public static void selectColor() {
        String[] colors = {"Красный", "Желтый", "Зелёный"};
        int data = 11;
        int limit1 = 10;
        int limit2 = 20;
        if (data <= limit1) {
            System.out.println(colors[0]);
        } else if (data <= limit2) {
            System.out.println(colors[1]);
        } else {
            System.out.println(colors[2]);
        }
    }

    public static void compareNumbers() {
        int a = 17;
        int b = 11;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result = initValue;
        if (increment) {
            result += delta;
        } else {
            result -= delta;
        }
        System.out.println(result);
    }

}
