package ru.otus.java.basic.homeworks.homework12;

public class Homework {
    public static void main(String[] args) {
        boolean eatResult;
        final int foodNorm = 100;
        StringBuilder str = new StringBuilder();
        Plate plate = new Plate(foodNorm);
        Cat[] catArr = {
                new Cat("Пушок",25),
                new Cat("Персик",35),
                new Cat("Барсик",20),
                new Cat("Рыся",30),
                new Cat("Тоша",40)
        };
        
        for (int i = 0; i < catArr.length; i++) {
            str.append("\n").append(plate.info()).append(catArr[i].info());
            for (int j = 0; j < 2; j++ ) {
                eatResult = catArr[i].tryToEat(plate);
                str.append("Кот ").append(catArr[i].getName());
                if (eatResult) {
                    str.append(" покушал успешно.\n");
                    break;
                } else {
                    str.append(" не смог покушать, недостаточно пищи. Насыпем полную тарелку корма. \n");
                    if (!plate.isFull()) {
                        plate.addFood(foodNorm);
                        str.append(plate.info());
                    }
                }                
            }
            str.append(catArr[i].info());
        }
        str.append("\n").append(plate.info());
        str.append("Коты поели, можно и поспать.");
        System.out.println(str);
    }
}
