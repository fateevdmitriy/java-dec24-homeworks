package ru.otus.java.basic.homeworks.homework12;

public class Cat {
    String name;
    int appetite;
    boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    
    public boolean tryToEat(Plate plate) {
        boolean tryResult = !satiety && appetite <= plate.curAmount;
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
