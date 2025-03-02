package ru.otus.java.basic.homeworks.homework17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBookMap;

    public PhoneBook() {
        this.phoneBookMap = new HashMap<>();
    }

    public PhoneBook(Map<String, Set<String>> phoneBookMap) {
        this.phoneBookMap = phoneBookMap;
    }

    public void add(String name, String phone) {
        if (phoneBookMap.containsKey(name)) {
            Set<String> phoneSet = phoneBookMap.get(name);
            if (phoneSet.contains(phone)) {
                System.out.println("Номер телефона " + phone + " не добавлен для " + name + ", так как такой номер уже есть для абонента.");
            } else {
                phoneSet.add(phone);
                System.out.println("Номер телефона " + phone + " добавлен для " + name + ".");
            }
        } else {
            Set<String> phoneSet = new HashSet<>();
            phoneSet.add(phone);
            phoneBookMap.put(name, phoneSet);
            System.out.println("Новый абонент " + name + " и номер телефона " + phone + " добавлены.");
        }
    }

    public Set<String> find(String name) {
        if (phoneBookMap.containsKey(name)) {
            return phoneBookMap.get(name);
        }
        return new HashSet<>();
    }

    public String findWithMsg(String name) {
        Set<String> findResultSet = find(name);
        return "По имени " + name + " в телефонной книге " +
                (findResultSet.isEmpty() ? "не найдено ни одного телефона." : "найдены телефоны: " + String.join(", ", find(name)));
    }

    public boolean containsPhoneNumber(String phone) {
        for (Set<String> phoneSet : phoneBookMap.values()) {
            if (!phoneSet.isEmpty() && phoneSet.contains(phone)) {
                return true;
            }
        }
        return false;
    }

    public String containsPhoneNumberWithMsg(String phone) {
        return "Телефон " + phone + (containsPhoneNumber(phone) ? "" : " не") + " найден в телефонной книге.";
    }
}
