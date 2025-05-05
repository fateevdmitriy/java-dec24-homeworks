package main.java.ru.otus.java.basic.homeworks.homework31;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayChecks {
    private static final Logger logger = LogManager.getLogger(ArrayChecks.class);
    
    public int[] getArrayPartRightToLastValueOf(int[] inArray, int searchValue) {
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

    public boolean isArrayContainsOnlyAllowedValues(int[] arrayToCheck) {
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

}
