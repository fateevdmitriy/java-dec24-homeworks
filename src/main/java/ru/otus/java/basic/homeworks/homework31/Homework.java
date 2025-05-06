package ru.otus.java.basic.homeworks.homework31;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Homework {
    private static final Logger logger = LogManager.getLogger(Homework.class);
    
    public static void main(String[] args) {
        int searchInt = 1;
        int[] testArray1 = {3, 6, 1, 0, 1, 7, 10, 1, 4, 9, 2, 5, 8};
        int[] testArray2 = {2, 1, 1, 1, 2, 1};
        ArrayChecks arrayChecks = new ArrayChecks();
        
        System.out.println("Исходный массив для получения его части, следующей за последней единицей: " + Arrays.toString(testArray1));
        logger.info("Исходный массив для получения его части, следующей за последней единицей: {}", Arrays.toString(testArray1));
        int[] result1 = arrayChecks.getArrayPartRightToLastValueOf(testArray1, searchInt);
        System.out.println("Элементы исходного массива, идущие после последней единицы: " + Arrays.toString(result1));
        logger.info("Результирующий массив, полученный как часть исходного массива, следующая за последней единицей: {}", Arrays.toString(result1));
        
        System.out.println("Исходный массив для проверки, что в него входят и 1 и 2 и только они: " + Arrays.toString(testArray2));
        logger.info("Исходный массив для проверки, что в него входят и 1 и 2 и только они: {}", Arrays.toString(testArray2));
        boolean result2 =  arrayChecks.isArrayContainsOnlyAllowedValues(testArray2);
        System.out.println("Проверка состоит ли массив и 1 и 2 и только их: " + result2);
        logger.info("Результат проверки входного массива, что он состоит только из чисел 1 и 2. Если в массиве присутствуют числа кроме 1 и 2, или нет хотя бы одной единицы или двойки, то проверка не пройдена: {}", result2);
    }
    
}
