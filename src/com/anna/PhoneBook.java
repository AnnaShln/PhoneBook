package com.anna;

import java.util.*;

    //Хранит список людей и номеров их телефонов. У каждого человека может быть более одного номера телефона.
    //Методы: добавление / удаление человека, добавление / удаление телефона для заданного человека,
    //поиск номера(ов) телефона по заданному имени человека, поиск человека по заданному номеру телефона.
    //Телефон задаётся последовательностью символов из цифр, +, *, #, -.

public class PhoneBook {
    
    private Map<String, HashSet<String>> persons = new HashMap<>();
    String name; //private

    private HashSet<String> numbers = new HashSet<>(); //interface

    public void addFirstNumber(String number) {
        numbers.add(number);
    }

    // boolean
    public void addPerson(String name, String number) {
        persons.put(name, numbers);   //numbers method local + check of presence name in map through get
    }

    public void deletePerson(String name, String number) {
        persons.remove(name);
    }

    public void addNumber(String number, String name) {
        persons.get(name).add(number);
    }

    public void deleteNumber(String number, String name) {
        persons.get(name).remove(number);
    }

    //interface vs implementation
    public HashSet searchByName(String name) {
        persons.get(name); //assignment; return persons.get(...);
        return numbers;
    }

    public String searchByNumber (String number) {
        persons.get(number);    //
        return name;

        /*for (String key: persons.keySet()){
            persons.get(key);
        }*/
    }

    // phoneBookEnrty + set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(name, phoneBook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
