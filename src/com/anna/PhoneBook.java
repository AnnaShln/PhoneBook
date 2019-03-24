package com.anna;

import java.util.*;

//Хранит список людей и номеров их телефонов. У каждого человека может быть более одного номера телефона.
    //Методы: добавление / удаление человека, добавление / удаление телефона для заданного человека,
    //поиск номера(ов) телефона по заданному имени человека, поиск человека по заданному номеру телефона.
    //Телефон задаётся последовательностью символов из цифр, +, *, #, -.

public class PhoneBook {
    
    private Map<String, Set<String>> persons = new HashMap<>();

    public boolean addPerson(String name, String number) {
        Set<String> numbers = new HashSet<>();
        if (number.matches("[\\d+#*+-]+")) numbers.add(number);
        else return false;
        persons.put(name, numbers);
        return persons.containsKey(name);
    }

    public boolean deletePerson(String name) {
        persons.remove(name);
        return persons.containsKey(name);
    }

    public boolean addNumber(String number, String name) {
        if (number.matches("[\\d+#*+-]+")) {
            if (persons.containsKey(name))  return persons.get(name).add(number);
            else return false;
        }
        else return false;
    }

    public boolean deleteNumber(String number, String name) {
        if (number.matches("[\\d+#*+-]+")) {
            if (persons.containsKey(name)) return persons.get(name).remove(number);
            else return false;
        }
        else return false;
    }

    public Set searchByName(String name) {
        return persons.get(name);
    }

    public String searchByNumber (String number) {
        String wantedname = null;
        if (number.matches("[\\d+#*+-]+")) {
            for (String key : persons.keySet()) {
                persons.get(key);
                for (Object value : persons.get(key)) {
                    if (number == value) return wantedname = key;
                }
            }
            return wantedname;
        }
        else return null;
    }
}
