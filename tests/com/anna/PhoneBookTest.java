package com.anna;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addPerson() {
        PhoneBook example = new PhoneBook();
        Map actual = example.addPerson("Вера", "+2343-2423");
        Set<String> set1 = new HashSet<>();
        set1.add("+2343-2423");
        Map <String, Set<String>> expected = new HashMap<>();
        expected.put("Вера", set1);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void deletePerson() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Вера", "+2343-2423");
        example.addPerson("Лера", "#0983298");
        Map actual = example.deletePerson("Вера");
        Set<String> set1 = new HashSet<>();
        set1.add("#0983298");
        Map <String, Set<String>> expected = new HashMap<>();
        expected.put("Лера", set1);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void addNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        boolean actual = example.addNumber("85780240", "Катя");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void deleteNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("09238499339", "Катя");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void searchByName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        Set actual = example.searchByName("Катя");
        Set<String> expected = new HashSet<>();
        expected.add("09238499339");
        expected.add("85780240");
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void searchByNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        String actual = example.searchByNumber("85780240");
        String expected = "Катя";
        assertEquals(expected, actual);
    }
}