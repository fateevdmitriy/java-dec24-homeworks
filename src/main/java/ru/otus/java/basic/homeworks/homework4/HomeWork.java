package ru.otus.java.basic.homeworks.homework4;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        int[] testArrayToFill = new int[11];
        int[] testArray = new int[]{-2, 8, 5, 11, 9, 4, 17, -7, 16, 2, 7, 2};
        int fillValueForArray = 7;
        int incValueForArray = 3;

        repeatingOut(9, "To complicate is easy. To simplify is difficult.");
        sumArrayElementsGreaterThanCheckVal(new int[]{-3, 9, 5, 11, 8, 4, 17, -7, 10, 2}, 5);
        fillOneIntToArray(testArrayToFill, fillValueForArray);
        incEachArrayElement(testArray, incValueForArray);
        calcMaxSumHalfOfArray(testArray);
    }

    public static void repeatingOut(int repeatCnt, String repeatStr) {
        System.out.println("Задание_1: Повторить " + repeatCnt + " раз заданную строку \"" + repeatStr + "\".");
        for (int i = 1; i <= repeatCnt; i++) {
            System.out.println(i + ". " + repeatStr);
        }
    }

    public static void sumArrayElementsGreaterThanCheckVal(int[] arrayToSum, int checkVal) {
        System.out.println("Задание_2: Исходный массив: " + Arrays.toString(arrayToSum));
        int sumCheckedValues = 0;
        for (int j = 0; j < arrayToSum.length; j++) {
            if (arrayToSum[j] > checkVal) {
                sumCheckedValues += arrayToSum[j];
            }
        }
        System.out.println("Cумма элементов массива, которые больше чем число " + checkVal + " = " + sumCheckedValues);
    }

    public static void fillOneIntToArray(int[] arrayToFill, int valueForArray) {
        System.out.println("Задание_3: Число, которым заполнить массив: " + valueForArray + ", исходный массив: " + Arrays.toString(arrayToFill));
        for (int k = 0; k < arrayToFill.length; k++) {
            arrayToFill[k] = valueForArray;
        }
        System.out.printf("Массив заполненный указанным числом: " + Arrays.toString(arrayToFill));
    }

    public static void incEachArrayElement(int[] arrayToIncrement, int incrementValue) {
        System.out.println("Задание_4: Исходный массив: " + Arrays.toString(arrayToIncrement));
        for (int l = 0; l < arrayToIncrement.length; l++) {
            arrayToIncrement[l] += incrementValue;
        }
        System.out.println("Результирующий массив с инкрементом " + incrementValue + ": " + Arrays.toString(arrayToIncrement));
    }

    public static void calcMaxSumHalfOfArray(int[] arrayToCalc) {
        System.out.println("Задание_5: Исходный массив из " + arrayToCalc.length + " элементов: " + Arrays.toString(arrayToCalc));
        int leftHalfOfArraySize = arrayToCalc.length / 2;
        if (arrayToCalc.length > 0) {
            int leftHalfOfArraySumOfElements = arrayToCalc[0];
            for (int m = 1; m < leftHalfOfArraySize; m++) {
                leftHalfOfArraySumOfElements += arrayToCalc[m];
            }
            System.out.println("Сумма элементов левой половины массива: " + leftHalfOfArraySumOfElements);
            int rightHalfOfArraySumOfElements = arrayToCalc[leftHalfOfArraySize];
            for (int n = leftHalfOfArraySize + 1; n < arrayToCalc.length; n++) {
                rightHalfOfArraySumOfElements += arrayToCalc[n];
            }
            System.out.println("Сумма элементов правой половины массива: " + rightHalfOfArraySumOfElements);
            if (leftHalfOfArraySumOfElements > rightHalfOfArraySumOfElements) {
                System.out.println("Сумма элементов левой половины массива больше.");
            } else if (leftHalfOfArraySumOfElements < rightHalfOfArraySumOfElements) {
                System.out.println("Сумма элементов правой половины массива больше.");
            } else {
                System.out.println("Сумма элементов правой и левой половин массива равны.");
            }
        } else {
            System.out.println("Массив пуст. Невозможно посчитать сумму элементов левой и правой части.");
        }
    }

}
