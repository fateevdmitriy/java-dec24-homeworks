package ru.otus.java.basic.homeworks.homework18;

import java.util.Arrays;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        Person person1 = new Person(1000L,"Иванов Иван Иванович", Position.DIRECTOR);
        Person person2 = new Person(1100L,"Петров Петр Петрович", Position.MANAGER);
        Person person3 = new Person(1110L, "Антонов Антон Антоновмч", Position.ENGINEER);
        Person person4 = new Person(1111L, "Сергеев Сергей Сергеевич", Position.DRIVER);
        
        List<Person> personList = Arrays.asList(person1, person2, person3);
        
        PersonDataBase personDB = new PersonDataBase(personList);
        personDB.add(person4);
        Long searchedPersonId = 1110L;
        Person foundPerson = personDB.findById(searchedPersonId);
        System.out.println("Поиск персоны в базе данных по id = " + searchedPersonId + " " + 
                            (foundPerson == null ? "никого не нашёл." : "нашел персону с именем '" + foundPerson.getName() + "'."));
        if (foundPerson != null) {
            System.out.println("Является ли найденная персона руководителем: " + (personDB.isManager(foundPerson) ? "Да" : "Нет"));
            System.out.println("Является ли найденная персона исполнителем: " + (personDB.isEmployee(foundPerson.getId()) ? "Да" : "Нет"));    
        } 
        
        int[] srcArray = {99, 11, 57, 31, 2, 77, 50, 5, 90, 14};
        int arrLength = srcArray.length;
        System.out.println("Исходный масссив: "+Arrays.toString(srcArray));
        
        int[] arrayBubbleSorted = Arrays.copyOf(srcArray, arrLength);
        Sorting.bubbleSort(arrayBubbleSorted);
        System.out.println("Пузырьковая сортировка массива: "+Arrays.toString(arrayBubbleSorted));
        
        int[] arraySelectionSorted = Arrays.copyOf(srcArray, arrLength);
        Sorting.selectionSort(arraySelectionSorted);
        System.out.println("Сортировка массива выбором : "+Arrays.toString(arraySelectionSorted));
        
        int[] arrayInsertSorted = Arrays.copyOf(srcArray, arrLength);
        Sorting.insertionSort(arrayInsertSorted);
        System.out.println("Сортировка масссив вставкой: "+Arrays.toString(arrayInsertSorted));
        
        int[] arrayQuickSorted = Arrays.copyOf(srcArray, arrLength);
        Sorting.quickSort(arrayQuickSorted,0,arrLength - 1);
        System.out.println("Быстрая сортировка масссива: "+Arrays.toString(arrayQuickSorted));
    }
}
