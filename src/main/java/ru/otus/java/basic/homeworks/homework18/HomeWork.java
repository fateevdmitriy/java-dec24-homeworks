package ru.otus.java.basic.homeworks.homework18;

import java.util.Arrays;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        Person person1 = new Person("Иванов Иван Иванович", Position.DIRECTOR, 1000L);
        Person person2 = new Person("Петров Петр Петрович", Position.MANAGER, 1100L);
        Person person3 = new Person("Антонов Антон Антоновмч", Position.ENGINEER, 1110L);
        Person person4 = new Person("Сергеев Сергей Сергеевич", Position.DRIVER, 1111L);

        List<Person> personList = Arrays.asList(person1, person2, person3);
        PersonDataBase personDB = new PersonDataBase(personList);
        personDB.add(person4);
        Long searchedPersonId = 1100L;
        Person foundPerson = personDB.findById(searchedPersonId);
        System.out.println("Поиск персоны в базе данных по id = " + searchedPersonId + " " + 
                            (foundPerson == null ? "никого не нашёл." : "нашел персону с именем '" + foundPerson.getName() + 
                                    "'."));
        if (foundPerson != null) {
            System.out.println("Является ли найденная персона руководителем: " + (personDB.isManager(foundPerson) ? "Да" : "Нет"));
            System.out.println("Является ли найденная персона исполнителем: " + (personDB.isEmployee(foundPerson.getId()) ? "Да" : "Нет"));    
        } 
        
        int[] srcArray = {99, 11, 57, 31, 2, 77, 50, 5, 90, 14};
        int arrLength = srcArray.length;
        System.out.println("Исходный масссив: "+Arrays.toString(srcArray));
        
        int[] arrayBubbleSorted = Arrays.copyOf(srcArray,arrLength); 
        bubbleSort(arrayBubbleSorted);
        System.out.println("Пузырьковая сортировка массива: "+Arrays.toString(arrayBubbleSorted));
        
        int[] arraySelectionSorted = Arrays.copyOf(srcArray,arrLength);
        selectionSort(arraySelectionSorted);
        System.out.println("Сортировка массива выбором : "+Arrays.toString(arraySelectionSorted));
        
        int[] arrayInsertSorted = Arrays.copyOf(srcArray,arrLength);
        insertionSort(arrayInsertSorted);
        System.out.println("Сортировка масссив вставкой: "+Arrays.toString(arrayInsertSorted));
        
        int[] arrayQuickSorted = Arrays.copyOf(srcArray,arrLength);
        quickSort(arrayQuickSorted,0,arrLength - 1);
        System.out.println("Быстрая сортировка масссива: "+Arrays.toString(arrayQuickSorted));
    }

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
