package ru.otus.java.basic.homeworks.homework10;

public class HomeWork {

    public static void main(String[] args) {
        int ageLimit = 40;
        int boxSizeSm = 12;
        String boxColor1 = "белый";
        String boxColor2 = "зеленый";
        String thing1 = "яблоко";
        String thing2 = "груша";
        
        User[] users = {
                new User("Никулин", "Юрий", "Владимирович", 1991, "nikulinjv@mail.ru"),
                new User("Вицин", "Георгий", "Михайлович", 1988, "vitsingm@mail.ru"),
                new User("Моргунов", "Евгений", "Александрович", 1977, "morgunovea@mail.ru"),
                new User("Папанов", "Анатолий", "Дмитриевич", 1982, "papanovad@mail.ru"),
                new User("Демьяненко", "Александр", "Сергеевич", 1967, "demyanenkoas@mail.ru"),
                new User("Яковлев", "Юрий", "Васильевич", 1990, "yakovlevjv@mail.ru"),
                new User("Миронов", "Андрей", "Александрович", 1985, "mironovaa@mail.ru"),
                new User("Мягков", "Андрей", "Васильевич", 1968, "myagkovav@mail.ru"),
                new User("Куравлев", "Леонид", "Вячеславович", 1976, "kuravlevlv@mail.ru"),
                new User("Леонов", "Евгений", "Павлович", 1986, "leonovep@mail.ru")
        };

        for (int i = 0; i < users.length; i++) {
            if (users[i].getAge() > ageLimit) {
                users[i].info();
            }
        }

        Box box1 = new Box(boxSizeSm, boxColor1);
        box1.info();
        box1.setColor("");
        box1.setColor(boxColor2);
        box1.close();
        box1.info();
        box1.putInside("");
        box1.putInside(thing1);
        box1.open();
        box1.putInside(thing1);
        box1.info();
        box1.close();
        box1.getOutside();
        box1.open();
        box1.getOutside();
        box1.info();
        box1.putInside(thing2);
        box1.close();
        box1.info();                 
    }
    
}
