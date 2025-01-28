package ru.otus.java.basic.homeworks.homework5;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        int[] testArrayToFill = new int[11];
        int[] testArray1 = new int[]{-2, 8, 5, 11, 9, 4, 17, -7, 16, 2, 7, 2};
        int[] testArray2 = new int[]{-1, 2, 7, 3, -4, 1, 5, 0};
        int[] testArray3 = new int[]{4, -4, 3, 6, -6, 3, 10, 12, 15, 13};
        int[] testArray4 = new int[]{-88, -15, -6, 0, 1, 3, 7, 11, 25, 100};
        int[] testArray5 = new int[]{88, 15, 6, 0, -1, -3, -7, -11, -25, -100};
        int fillValueForArray = 7;
        int incValueForArray = 3;

        repeatingOut(9, "To complicate is easy. To simplify is difficult.");
        sumArrayElementsGreaterThanCheckVal(new int[]{-3, 9, 5, 11, 8, 4, 17, -7, 10, 2}, 5);
        fillOneIntToArray(testArrayToFill, fillValueForArray);
        incEachArrayElement(testArray1, incValueForArray);
        calcMaxSumHalfOfArray(testArray1);
        
        sumMultipleArrays(testArray1, testArray2, testArray3);
        findArrayElenetsPointOfBalance(testArray3);
        checkOrderInArray(testArray4); // мли параметр: testArray5 
        inverseArray(testArray4);
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
    
    public static void sumMultipleArrays(int[] array1, int[] array2, int[] array3) {
        System.out.println("Исходный массив_1: " + Arrays.toString(array1));
        System.out.println("Исходный массив_2: " + Arrays.toString(array2));
        System.out.println("Исходный массив_3: " + Arrays.toString(array3));
        int maxArrayLength = Math.max(Math.max(array1.length, array2.length), array3.length);
        if (maxArrayLength == 0) {
            System.out.println("Невозможно суммировать элементы массивов т.к. массивы пусты.");
            return;
        }
        int[] arrayToSum = new int[maxArrayLength];
        for (int i = 0; i < maxArrayLength; i++) {
            if (i < array1.length) {
                arrayToSum[i] += array1[i];
            }
            if (i < array2.length) {
                arrayToSum[i] += array2[i];
            }
            if (i < array3.length) {
                arrayToSum[i] += array3[i];
            }
        }
        System.out.println("Массив сумм элементов исходных массивов: " + Arrays.toString(arrayToSum));
    }

    public static void findArrayElenetsPointOfBalance(int[] intArray) {
        System.out.println("Исходный массив из " + intArray.length + " элементов: " + Arrays.toString(intArray));
        if (intArray.length == 0) {
            System.out.println("Невозможно найти \"точку\" равества левой и правой частей массива т.к. массив пуст.");
            return;
        }
        int leftPartArraySum;
        int rightPartArraySum;
        for (int i = 0; i < intArray.length - 1; i++) {
            leftPartArraySum = intArray[0];
            for (int j = 1; j <= i; j++) {
                leftPartArraySum += intArray[j];
            }
            rightPartArraySum = intArray[i + 1];
            for (int j = i + 2; j < intArray.length; j++) {
                rightPartArraySum += intArray[j];
            }
            System.out.println("Текущий индекс: " + i + ", суммы левой и правой частей массива: " + leftPartArraySum + ", " + rightPartArraySum);
            if (leftPartArraySum == rightPartArraySum) {
                System.out.println("В массиве найдена \"точка\", в которой сумма левой и правой части равны, она находится между " +
                        "индексами массива " + i + " и " + (i + 1) + ".");
                return;
            }
        }
        System.out.println("В массиве не найдена \"точка\", в которой сумма левой и правой части равны. ");
    }

    public static void checkOrderInArray(int[] checkArray) {
        System.out.println("Исходный массив: " + Arrays.toString(checkArray));
        if (checkArray.length == 0) {
            System.out.println("Невозможно проверить порядок элементов массива т.к. массив пуст.");
            return;
        }
        boolean isOrderCorrect = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите целое число - вариант проверки элементов массива:\n0 - они должны идти в порядке убывания, иначе - в " +
                "порядке возрастания:");
        int usersChoice = scanner.nextInt();
        for (int i = 0; i < checkArray.length - 1; i++) {
            if (usersChoice == 0) {
                if (checkArray[i] <= checkArray[i + 1]) {
                    isOrderCorrect = false;
                    break;
                }
            } else {
                if (checkArray[i] > checkArray[i + 1]) {
                    isOrderCorrect = false;
                    break;
                }
            }
        }
        if (usersChoice == 0) {
            if (isOrderCorrect) {
                System.out.println("Порядок элементов массива корректен, идут в порядке убывания.");
            } else {
                System.out.println("Порядок элементов массива некорректен, НЕ идут в порядке убывания.");
            }
        } else {
            if (isOrderCorrect) {
                System.out.println("Порядок элементов массива корректен, идут в порядке возрастания.");
            } else {
                System.out.println("Порядок элементов массива некорректен, НЕ идут в порядке возрастания.");
            }
        }
    }

    public static void inverseArray(int[] inArray) {
        System.out.println("Исходный массив: " + Arrays.toString(inArray));
        if (inArray.length == 0) {
            System.out.println("Невозможно проверить порядок элементов массива т.к. массив пуст.");
            return;
        }
        int[] inversedArray = new int[inArray.length];
        int index;
        for (int i = 0; i < inArray.length; i++) {
            index = inversedArray.length - 1 - i;
            inversedArray[index] = inArray[i];
        }
        System.out.println("Перевернутый массив: " + Arrays.toString(inversedArray));
    }

}
