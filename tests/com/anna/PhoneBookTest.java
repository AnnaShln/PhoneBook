package com.anna;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @org.junit.jupiter.api.Test
    void addPerson() {
        PhoneBook example = new PhoneBook();
        boolean actual = example.addPerson("Вера", "+233-2423");
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void addPerson_NullName() {
        PhoneBook example = new PhoneBook();
        boolean actual = example.addPerson(null, "+233-2423");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void addPerson_WrongNumber() {
        PhoneBook example = new PhoneBook();
        boolean actual = example.addPerson("Юля", "+233-ssflk");
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void deletePerson() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Вера", "+2343-2423");
        example.addPerson("Лера", "#0983298");
        boolean actual = example.deletePerson("Вера");
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void deletePerson_NoNameInMap() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Вера", "+2343-2423");
        example.addPerson("Лера", "#0983298");
        boolean actual = example.deletePerson("Катя");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void deletePerson_NullName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Вера", "+2343-2423");
        example.addPerson("Лера", "#0983298");
        boolean actual = example.deletePerson(null);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void addNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        boolean actual = example.addNumber("85780240", "Маша");
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void addNumber_WrongNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "+293874837");
        example.addPerson("Катя", "#0923-8499339");
        boolean actual = example.addNumber("!fsdf0240", "Юля");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void addNumber_NoName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "+293874837");
        example.addPerson("Катя", "#0923-8499339");
        boolean actual = example.addNumber("85780240", "Юля");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void addNumber_NumberExists() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "+293874837");
        example.addPerson("Катя", "#0923-8499339");
        boolean actual = example.addNumber("+293874837", "Маша");
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void deleteNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "+09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("+09238499339", "Катя");
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void deleteNumber_NoName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "+09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("+09238499339", "Варя");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void deleteNumber_WrongNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "+09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("Hello", "Катя");
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void deleteNumber_NoNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "+09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("+3234-243", "Катя");
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void searchByName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        Set actual = example.searchByName("Катя");
        Set<String> expected = new HashSet<>();
        expected.add("85780240");
        expected.add("09238499339");
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void searchByName_NoName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        Set actual = example.searchByName(null);
        assertNull(actual);
    }

    @org.junit.jupiter.api.Test
    void searchByNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        String actual = example.searchByNumber("85780240");
        assertEquals("Катя",actual);
    }
    @org.junit.jupiter.api.Test
    void searchByNumber_WrongNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        String actual = example.searchByNumber("!85780240");
        assertNull(actual);
    }
}