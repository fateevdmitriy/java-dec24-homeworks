package main.java.ru.otus.java.basic.homeworks.homework27.boxes;

import main.java.ru.otus.java.basic.homeworks.homework27.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    
    private final String name; 
    private ArrayList<T> objects;

    public Box(String name) {
        this.name = name;
        this.objects = new ArrayList<>();
    }
    
    public Box(String name, ArrayList<T> objects) {
        this.name = name;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getObjects() {
        return objects;
    }
    
    public String getObjectsToString() {
        ArrayList<String> objectsStr =  new ArrayList<>();
        for(T object : getObjects()){
            objectsStr.add(object.toString());
        }
        return String.join("; ", objectsStr);
        
    }

    public void setObjects(ArrayList<T> objects) {
        this.objects = objects;
    }

    public boolean isFruitInBox (T checkObj) {
        for (T object : getObjects()) {
            if (object.getName().equals(checkObj.getName()) && object.getWeight().equals(checkObj.getWeight())) {
                return true;
            }
        }
        return false;
    }

    public void add(T obj) {
        if (isFruitInBox(obj)) {
            System.out.println("Нельзя добавить фрукт "+obj.getName()+" в коробку " + this.getName() + " т.к. он уже есть в ней.");
            return;
        }
        objects.add(obj);
    }

    public void remove(T obj) {
        if (!isFruitInBox(obj)) {
            System.out.println("Нельзя удалить фрукт "+obj.getName()+" из коробки " + this.getName() + "т.к. его нет в ней.");
            return;
        }
        objects.remove(obj);
    }
    
    public Float weight() {
        Float boxWeight = 0f;
        for (T object : this.getObjects()) {
            boxWeight += object.getWeight();
        }
        return boxWeight;
    }

    public Boolean compare(Box<? extends Fruit> another) {
        if (this.weight() == null || another == null) {
            return false;
        }
        return Math.abs(this.weight() - another.weight()) < 0.0001;
    }
    
    public void transferToBox(Box<? super T> dstBox) {
        if (this.getObjects().isEmpty()) {
            System.out.println("Исходная коробка пуста, пересыпать из неё нечего.");
            return;
        }
        for (T object : this.getObjects()) {
            dstBox.add(object);
        }
        this.setObjects(new ArrayList<>());
    }

}
