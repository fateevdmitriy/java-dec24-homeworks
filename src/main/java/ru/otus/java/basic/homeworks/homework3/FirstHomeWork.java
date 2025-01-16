package ru.otus.java.basic.homeworks.homework3;

import java.util.Scanner;

public class FirstHomeWork {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите программу для запуска (от 1 до 5):");
        int usersChoice = scanner.nextInt();

        if (usersChoice == 1) {
            greetings();
        } else {
            if (usersChoice == 2) {
                int a = randomInt(10 * usersChoice);
                int b = randomInt(-10 * usersChoice);
                int c = randomInt(5 * usersChoice);
                checkSign(a,b,c);
            } else {
                if (usersChoice == 3) {
                    selectColor();
                } else {
                    if (usersChoice == 4) {
                        compareNumbers();
                    } else {
                        if (usersChoice == 5) {
                            int d = randomInt(15 * usersChoice);
                            int e = randomInt(-15 * usersChoice);
                            boolean f = randomInt(10) > 0;
                            addOrSubtractAndPrint(d,e,f);
                        }
                    }
                }
            }
        }

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
        int data = randomInt(30);
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
        int a = randomInt(100);
        int b = randomInt(100);
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

    public static int randomInt(int multiplier) {
        int result = (int) (Math.random() * multiplier);
        System.out.println("Random int: "+result);
        return result;
    }

}