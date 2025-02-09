package ru.otus.java.basic.homeworks.homework10;

import java.time.Year;

public class User {
    private String lastName;
    private String firstName;
    private String patronymic;
    private int birthYear;
    private String email;
    private int curYear = Year.now().getValue();

    public User(String lastName, String firstName, String patronymic, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        if (curYear > birthYear) {
            return curYear - birthYear;
        }
        return 0;
    }

    public void info() {
        System.out.printf("ФИО: %s %s %s%nГод рождения: %d%ne-mail: %s%n%n", lastName, firstName, patronymic, birthYear, email);
    }

}
