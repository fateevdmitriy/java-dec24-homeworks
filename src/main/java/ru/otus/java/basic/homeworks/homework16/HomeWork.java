package ru.otus.java.basic.homeworks.homework16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 7, 0, 13, 5, 9, 2, 6, 1, 10));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 12, 6, 18, 0, 2, 8, 4, 9, 14, 19, 22));
        final int MIN_INT = 5;
        final int MAX_INT = 15;
        final int THRESHOLD_NUM = 5;
        final int REPL = 3;
        final int INCR = 2;
        final int MIN_AGE = 35;
        final int AVG_AGE = 33;
        Employee emp1 = new Employee("Антон", 36);
        Employee emp2 = new Employee("Евгений", 23);
        Employee emp3 = new Employee("Татьяна", 28);
        Employee emp4 = new Employee("Ирина", 38);
        Employee emp5 = new Employee("Иван", 44);
        Employee emp6 = new Employee("Сергей", 40);
        List<Employee> empList = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6));

        System.out.println("Массив с набором последовательных значений от " + MIN_INT + " до " + MAX_INT + ": " +
                arrayMinMax(MIN_INT, MAX_INT));

        System.out.println("Список: " + list1 + ". Сумма элементов массива > " + THRESHOLD_NUM + " " +
                "составляет " + arraySumElementsMoreThan(THRESHOLD_NUM, Arrays.asList(4, 7, 0, 13, 5, 9, 2, 6, 1, 10)) + ".");

        System.out.println("1. Список в исходном виде: " + list1);
        arraySetToNum(REPL, list1);
        System.out.println("2. Список после перезаписи всех его элементов числом " + REPL + ": " + list1);

        System.out.println("1. Список в исходном виде: " + list2);
        arrayIncToNum(INCR, list2);
        System.out.println("2. Список после увеличения элементов на число " + INCR + ": " + list2);

        System.out.println("Список имен сотрудников: " + String.join(", ", arrayEmpNames(empList)) + ".");

        System.out.println("Список имен сотрудников с возрастом от " + MIN_AGE + " лет: " +
                String.join(", ", arrayEmpNamesByMinAge(MIN_AGE, empList)) + ".");

        System.out.println("Превышает ли средний возраст сотрудников из списка значение " + AVG_AGE + ": " +
                (isEmpAvgAgeMoreThreshold(AVG_AGE, empList) ? "Да" : "Нет") + ".");

        try {
            Employee youngestEmp = findYoungestEmp(empList);
            System.out.println("Самый молодой сотрудник из списка сотруднриков: " + youngestEmp.getName() + ", его возраст: " + youngestEmp.getAge() + ".");
        } catch (IllegalArgumentException iae) {
            System.out.println("Не удалось определить самого молодого сотрудников из списка сотрудников т.к их список пуст.");
        }

    }

    public static ArrayList<Integer> arrayMinMax(int min, int max) {
        ArrayList<Integer> arrMinMax = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arrMinMax.add(i);
        }
        return arrMinMax;
    }

    public static int arraySumElementsMoreThan(int threshold, List<Integer> arrInt) {
        int sumNumUpThreshold = 0;
        for (Integer numInt : arrInt) {
            if (numInt > threshold) {
                sumNumUpThreshold += numInt;
            }
        }
        return sumNumUpThreshold;
    }

    public static void arraySetToNum(int num, List<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            arrList.set(i, num);
        }
    }

    public static void arrayIncToNum(int num, List<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            arrList.set(i, arrList.get(i) + num);
        }
    }

    public static List<String> arrayEmpNames(List<Employee> empList) {
        List<String> empNamesList = new ArrayList<>();
        for (Employee emp : empList) {
            empNamesList.add(emp.getName());
        }
        return empNamesList;
    }

    public static List<String> arrayEmpNamesByMinAge(int minAge, List<Employee> empList) {
        List<String> empNamesByAgeList = new ArrayList<>();
        for (Employee emp : empList) {
            if (emp.getAge() >= minAge) {
                empNamesByAgeList.add(emp.getName());
            }
        }
        return empNamesByAgeList;
    }

    public static boolean isEmpAvgAgeMoreThreshold(int threshold, List<Employee> empList) {
        int empAgeSum = 0;
        for (Employee emp : empList) {
            empAgeSum += emp.getAge();
        }
        return (double) empAgeSum / empList.size() > threshold;
    }

    public static Employee findYoungestEmp(List<Employee> empList) throws IllegalArgumentException {
        if (empList.isEmpty()) {
            throw new IllegalArgumentException("Список сотрудников пуст.");
        }
        Employee youngestEmp = empList.get(0);
        for (int i = 1; i < empList.size(); i++) {
            if (empList.get(i).getAge() < youngestEmp.getAge()) {
                youngestEmp = empList.get(i);
            }
        }
        return youngestEmp;
    }
}