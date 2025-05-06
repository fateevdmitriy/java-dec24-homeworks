package ru.otus.java.basic.homeworks.homework31; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayChecksTest {
    private ArrayChecks arrayChecks;
    
    @BeforeEach
    public void init() {
        arrayChecks = new ArrayChecks();
    }
    
    @Test
    @DisplayName("Тест: возвращает ошибку, если результирующий массив включает не элементы исходного массива, идущие после " +
            "последней единицы")
    public void testGetArrayPartRightToLastValueOf() {
        int[] inArray = {5, 3, 1, 7, 1, 3, 5, 7, 9};
        int[] expectedArray = {3, 5, 7, 9};
        Assertions.assertArrayEquals(expectedArray, arrayChecks.getArrayPartRightToLastValueOf(inArray,1));
    }
    
    @Test
    @DisplayName("Тест: возвращает ошибку, если входящий массив включает не только числа 1 и 2.")
    public void testIsArrayContainsOnlyAllowedValues() {
        int[] correctArray = {1, 2, 2, 1, 2, 1};
        Assertions.assertTrue(arrayChecks.isArrayContainsOnlyAllowedValues(correctArray));
    }

    @Test
    @DisplayName("Тест: возвращает ошибку, если входящий массив включает числа 1 и 2 и только их.")
    public void testIsArrayContainsNotOnlyAllowedValues() {
        int[] incorrectArray = {1, 3, 2, 1, 2, 1};
        Assertions.assertFalse(arrayChecks.isArrayContainsOnlyAllowedValues(incorrectArray));
    }
}
