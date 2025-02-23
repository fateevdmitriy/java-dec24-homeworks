package ru.otus.java.basic.homeworks.homework15.exceptions;

public class AppArrayDataException extends RuntimeException {
    
    public AppArrayDataException(int errorRow, int errorColumn) {
        super("[AppArrayDataException]: Ошибка преобразования типов данных в обрабатываемом массиве: строка " + errorRow + " столбец " 
                + errorColumn + ".");
    }
    
}
