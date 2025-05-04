package main.java.ru.otus.java.basic.homeworks.homework27.fruits;

public class Fruit {
    private final String name;
    private final Float weight;     
    
    public Fruit(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return "название фрукта: " + this.getName() + ", вес фрукта: " + this.getWeight();
    }
}
