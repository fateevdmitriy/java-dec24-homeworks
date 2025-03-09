package ru.otus.java.basic.homeworks.homework18;

import java.util.*;

public class PersonDataBase {
    private Map<Long, Person> personMap;
    private final static List<Position> managementPositions = Arrays.asList(Position.MANAGER, Position.DIRECTOR,
                                                                        Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER);
    public PersonDataBase() {         
        this.personMap = new HashMap<>();
    }

    public PersonDataBase(List<Person> personList) {
        this.personMap = new HashMap<>();
        for(Person person : personList) {
            this.personMap.putIfAbsent(person.getId(), person);
        }
    }
    
    public Person findById(Long id) {
        if (personMap.containsKey(id)) {
            return personMap.get(id);    
        }
        return null;
    }
    
    void add(Person person) {
        if (person != null) {
            personMap.putIfAbsent(person.getId(), person);    
        }
    }

    boolean isManager(Person person) {
        return person != null && managementPositions.contains(person.getPosition());    
    }

    boolean isEmployee(Long id) {
        Person person = findById(id);
        return person != null && !managementPositions.contains(person.getPosition());
    }
    
}
