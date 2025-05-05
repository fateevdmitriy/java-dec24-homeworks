package main.java.ru.otus.java.basic.homeworks.homework31;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Homework {
    private static final Logger logger = LogManager.getLogger(Homework.class);
    
    public static void main(String[] args) {
        ArrayChecks arrayChecks = new ArrayChecks();
        
        int searchInt = 1;
        int[] testArray1 = {3, 6, 1, 0, 1, 7, 10, 1, 4, 9, 2, 5, 8};
        int[] testArray2 = {2, 1, 1, 1, 2, 1};
        System.out.println("Исходный массив: " + Arrays.toString(testArray1));
        int[] resultArray = arrayChecks.getArrayPartRightToLastValueOf(testArray1, searchInt);
        System.out.println("Элементы исходного массива, идущие после последней единицы: " + Arrays.toString(resultArray));
        System.out.println("Исходный массив: " + Arrays.toString(testArray2));
        System.out.println("Проверка состоит ли массив только из 1 и 2: " + arrayChecks.isArrayContainsOnlyAllowedValues(testArray2));
        logger.info("Завершщение работы.");
    }

    /*
    public static int[] getArrayPartRightToLastValueOf(int[] inArray, int searchValue) {
        int searchPos = -1;
        for (int i = inArray.length - 1; i >= 0; i--) {
            if (inArray[i] == searchValue) {
                searchPos = i;
                break;
            }
        }
        if (searchPos < 0) throw new RuntimeException("Исходный массив не содержит ни одного искомого символа = " + searchValue);
        return Arrays.copyOfRange(inArray, searchPos + 1, inArray.length);
    }

    public static boolean isArrayContainsOnlyAllowedValues(int[] arrayToCheck) {
        boolean isIntEquals1 = false;
        boolean isIntEquals2 = false;
        boolean isIntForbidden = false;

        for (int i = 0; i < arrayToCheck.length; i++) {
            if (arrayToCheck[i] == 1) {
                isIntEquals1 = true;
            } else if (arrayToCheck[i] == 2) {
                isIntEquals2 = true;
            } else {
                isIntForbidden = true;
            }
        }
        return isIntEquals1 && isIntEquals2 && !isIntForbidden;
    }
    */
}
