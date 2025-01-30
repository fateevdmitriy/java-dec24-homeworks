package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        int[][] testArr = {{1, 3, 9, 5, 7, 8}, {3, 5, 2, 11, 7, 1}, {5, 9, 3, 2, 4, -6}, {6, -21, 1, 3, 7, 4}, {4, 15, 1, 6, 2, 11}};
        
        System.out.println("Сумма положительных элементов массива: "+sumOfPositiveElements(testArr));
        printSquare(10, '*');
        zeroOutBothDiagonalsOfArray(testArr);
        System.out.println("Максимальный элемент массива: "+findMax(testArr));
        System.out.println("Сумма элементов указанной строки массива: " + sumElementsOfSpecifiedArrayRow(2, testArr));
    }

    public static int sumOfPositiveElements(int[][] inArray2d) {
        int sumOfPositiveElements = 0;
        System.out.println("Исходный массив: " + Arrays.deepToString(inArray2d));
        if (inArray2d.length == 0) {
            System.out.println("Невозможно найти сумму позитивных элементов массива, т.к. массив пуст.");
            return sumOfPositiveElements;
        }
        for (int i = 0; i < inArray2d.length; i++) {
            for (int j = 0; j < inArray2d[i].length; j++) {
                if (inArray2d[i][j] > 0) {
                    sumOfPositiveElements += inArray2d[i][j];
                }
            }
        }
        return sumOfPositiveElements;
    }

    public static void printSquare(int size, char printChar) {
        char[][] arrToPrint = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1) {
                    arrToPrint[i][j] = printChar;
                } else if (j == 0 || j == size - 1) {
                    arrToPrint[i][j] = printChar;
                } else {
                    arrToPrint[i][j] = ' ';
                }
                System.out.print(arrToPrint[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void zeroOutBothDiagonalsOfArray(int[][] squareArray) {
        System.out.println("Исходный массив: " + Arrays.deepToString(squareArray));
        System.out.println("Массив с зануленными диагоналями: ");
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                if (j == i || j == squareArray.length - 1 - i) {
                    squareArray[i][j] = 0;
                }
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] inArray) {
        System.out.println("Исходный массив: " + Arrays.deepToString(inArray));
        if (inArray.length == 0) {
            System.out.println("Невозможно найти максимальный элемент массива, т.к. массив пуст.");
            return 0;
        }
        int maxElement = inArray[0][0];
        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray.length; j++) {
                if (inArray[i][j] > maxElement) {
                    maxElement = inArray[i][j];
                }
            }
        }
        return maxElement;
    }

    public static int sumElementsOfSpecifiedArrayRow(int rowToSum, int[][] calcArray) {
        System.out.println("Заданный индекс строки массива: " + rowToSum + "\nИсходный массив: " + Arrays.deepToString(calcArray));
        if (rowToSum >= calcArray.length) {
            System.out.println("Невозможно найти сумму элементов строки массива с индексом " + rowToSum + ", т.к. заданный индекс больше " +
                    "максимального индекса строки в массиве.");
            return -1;
        } else {
            int rowSum = calcArray[rowToSum][0];
            for (int j = 1; j < calcArray[rowToSum].length; j++) {
                rowSum += calcArray[rowToSum][j];
            }
            return rowSum;
        }
    }

}
