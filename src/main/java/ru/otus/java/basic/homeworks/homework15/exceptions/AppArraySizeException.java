package ru.otus.java.basic.homeworks.homework15.exceptions;

public class AppArraySizeException extends RuntimeException {
    
    public AppArraySizeException(int arrayDim) {
        super("[AppArraySizeException]: Ошибка в размерности обрабатываемого двумерного массива. Массив должен иметь размерность " 
                + arrayDim + "x" + arrayDim + " элемента.");
    }
    
}
