package main.java.ru.otus.java.basic.homeworks.homework31; 
             
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayChecksTest {
    
    private ArrayChecks arrayChecks;
    
    @BeforeEach
    public void init() {
        arrayChecks = new ArrayChecks();
    }
    
    @Test
    @DisplayName("Test: проверка_1")
    public void testGetArrayPartRightToLastValueOf() {
        int[] inArray = {5, 3, 1, 7, 1, 3, 5, 7, 9};
        int[] expectedArray = {3, 5, 7, 9};
        Assertions.assertArrayEquals(expectedArray, arrayChecks.getArrayPartRightToLastValueOf(inArray,1));
    }
    
    @Test
    @DisplayName("Test: проверка_2")
    public void testIsArrayContainsOnlyAllowedValues() {
        int[] correctArray = {1, 2, 2, 1};
        int[] incorrectArray = {1, 0, 2, 1, 2};
        Assertions.assertTrue(arrayChecks.isArrayContainsOnlyAllowedValues(correctArray));
        Assertions.assertFalse(arrayChecks.isArrayContainsOnlyAllowedValues(incorrectArray));
    }
    
}
