package ru.otus.java.basic.homeworks.homework18;

public class Sorting {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexMin = i;
            int valueMin = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < valueMin) {
                    indexMin = j;
                    valueMin = array[j];
                }
            }
            array[indexMin] = array[i];
            array[i] = valueMin;
        }
    }

    public static void insertionSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int curValue = array[i];
            for (j = i; j > 0 && curValue < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = curValue;
        }
    }

    public static void quickSort(int[] array, int from, int to) {
        if (array.length == 0 || from >= to) {
            return;
        }
        int midIndex = from + (to - from) / 2;
        int border = array[midIndex];
        int i = from;
        int j = to;
        while (i <= j) {
            while (array[i] < border) i++;
            while (array[j] > border) j--;
            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }
        if (from < j) quickSort(array, from, j);
        if (to > i) quickSort(array, i, to);
    }
}
