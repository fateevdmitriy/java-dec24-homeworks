package ru.otus.java.basic.homeworks.homework15;

import ru.otus.java.basic.homeworks.homework15.exceptions.AppArrayDataException;
import ru.otus.java.basic.homeworks.homework15.exceptions.AppArraySizeException;

public class HomeWork {

    public static void main(String[] args) {
        final int DIMENSION = 4;
        int result;
        String[][] strArray1 = {
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"},
                {"40", "41", "42", "43"}
        };

        try {
            result = sumArrayElements(DIMENSION, strArray1);
            System.out.println("Суммирование элементов массива выполнено успешно. Сумма = " + result + ".");
        } catch (AppArraySizeException | AppArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int sumArrayElements(int arrDim, String[][] strArr) throws AppArraySizeException, AppArrayDataException {
        if (strArr.length != arrDim || strArr[0].length != arrDim) {
            throw new AppArraySizeException(arrDim);
        }
        int arrSum = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                try {
                    arrSum += Integer.parseInt(strArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i + 1, j + 1);
                }
            }
        }
        return arrSum;
    }

}
