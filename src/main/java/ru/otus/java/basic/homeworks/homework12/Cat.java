package ru.otus.java.basic.homeworks.homework12;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }
    
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    
    public boolean tryToEat(Plate plate) {
        boolean tryResult = !satiety && appetite <= plate.getCurAmount();
        if (tryResult) {
            tryResult = plate.reduceFood(appetite);
            satiety = tryResult;
        }
        return tryResult;
    }
    
    public String info() {
        return "Кот '"+name+"', аппетит: "+appetite+", сытость: "+(satiety ? "сыт" : "голоден")+".\n";
    }
}
