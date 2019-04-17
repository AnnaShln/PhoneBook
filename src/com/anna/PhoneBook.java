package com.anna;

import java.util.*;

public class PhoneBook {
    
    private Map<String, Set<String>> persons = new HashMap<>();

    public boolean addPerson(String name, String number) {
        if (persons.containsKey(name) || name == null) return false;
        else {
            Set<String> numbers = new HashSet<>();
            if (number.matches("[\\d+#*-]+")) numbers.add(number);
            else return false;
            persons.put(name, numbers);
            return persons.containsKey(name);
        }
    }

    public boolean deletePerson(String name) {
        if (persons.containsKey(name)) {
            persons.remove(name);
            return true;
        }
        else return false;
    }

    public boolean addNumber(String number, String name) {
        if (persons.containsKey(name)) {
            if (number.matches("[\\d+#*-]+")) {
                for (String value : persons.get(name)) {
                    if (number.equals(value)) return false;
                }
                return persons.get(name).add(number);
            }
            else return false;
        }
        else return false;
    }

    public boolean deleteNumber(String number, String name) {
        if (persons.containsKey(name)) {
            if (number.matches("[\\d+#*-]+")) {
                for (String value : persons.get(name)) {
                    if (number.equals(value)) {
                        persons.get(name).remove(number);
                        return true;
                    }
                }
                return false;
            }
            else return false;
        }
        else return false;
    }

    public Set searchByName(String name) {
        return persons.getOrDefault(name, null);
    }

    public String searchByNumber (String number) {
        String wantedname = null;
        if (number.matches("[\\d+#*-]+")) {
            for (String key : persons.keySet()) {
                for (String value : persons.get(key)) {
                    if (number.equals(value)) return wantedname = key;
                }
            }
            return wantedname;
        }
        else return null;
    }
}