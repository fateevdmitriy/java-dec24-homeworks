package ru.otus.java.basic.homeworks.homework10;

public class Box {
    private int size;
    private String color;
    private boolean isOpened;
    private String thing;

    public Box(int size, String color) {
        this.size = size;
        this.color = color;
        this.isOpened = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean isEmpty() {
        return thing == null;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setColor(String color) {
        if (color.isEmpty()) {
            System.out.println("Не получается изменить цвет коробки т.к. новый цвет не указан.");
            return;
        }
        this.color = color;
        System.out.println("Цвет коробки изменён на " + color + ".");
    }

    public void open() {
        isOpened = true;
        System.out.println("Коробка открыта.");
    }

    public void close() {
        isOpened = false;
        System.out.println("Коробка закрыта.");
    }

    public void putInside(String thing) {
        if (thing.isEmpty()) {
            System.out.println("Не получается положить в коробку предмет т.к. предмет не указан.");
            return;
        }
        if (!isOpened()) {
            System.out.println("Не получается положить в коробку предмет: " + thing + ", т.к. коробка закрыта.");
            return;
        }
        if (!isEmpty()) {
            System.out.println("Не получается положить в коробку предмет: " + thing + ", т.к. коробка не пуста.");
            return;
        }
        this.thing = thing;
        System.out.println("Положили в коробку предмет: " + thing + ".");
    }

    public void getOutside() {
        if (!isOpened()) {
            System.out.println("Не получается достать из коробки ничего, т.к. коробка закрыта.");
            return;
        }
        if (isEmpty()) {
            System.out.println("Не получается достать из коробки ничего, т.к. коробка пуста.");
            return;
        }
        System.out.println("Достали из коробку предмет: " + thing + ".");
        this.thing = null;
    }

    public void info() {
        System.out.print("Инфо о коробке: цвет: " + getColor() + ", размер: " + getSize());
        if (isOpened()) {
            System.out.print(", открыта");
        } else {
            System.out.print(", закрыта");
        }
        if (isEmpty()) {
            System.out.println(" и пуста.");
        } else {
            System.out.println(" и не пуста, в ней лежит " + thing + ".");
        }
    }
}
