package com.anna;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @org.junit.jupiter.api.Test
    void addPerson() {
        PhoneBook example = new PhoneBook();
        Boolean actual = example.addPerson("Вера", "+233-2423");
        assertEquals(true, actual);
    }

    @org.junit.jupiter.api.Test
    void deletePerson() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Вера", "+2343-2423");
        example.addPerson("Лера", "#0983298");
        Boolean actual = example.deletePerson("Варя");
        assertEquals(false, actual);
    }

    @org.junit.jupiter.api.Test
    void addNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        boolean actual = example.addNumber("85780240", "Юля");
        assertEquals(false, actual);
    }

    @org.junit.jupiter.api.Test
    void deleteNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "+09238499339");
        example.addNumber("85780240", "Катя");
        boolean actual = example.deleteNumber("+09238499339", "Катя");
        assertEquals(true, actual);
    }

    @org.junit.jupiter.api.Test
    void searchByName() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        Set actual = example.searchByName("Юля");
        assertEquals(null, actual);
    }

    @org.junit.jupiter.api.Test
    void searchByNumber() {
        PhoneBook example = new PhoneBook();
        example.addPerson("Маша", "293874837");
        example.addPerson("Катя", "09238499339");
        example.addNumber("85780240", "Катя");
        String actual = example.searchByNumber("!85780240");
        assertEquals(null, actual);
    }
}