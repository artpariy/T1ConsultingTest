package ru.pariy.restapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SymbolFrequencyTest {
    private final SymbolFrequency symbolFrequency = new SymbolFrequency();

    @Test
    public void testCounterWithEmptyString() {
        Map<Character, Integer> result = symbolFrequency.counter("");
        Map<Character, Integer> expected = new LinkedHashMap<>();
        assertEquals(expected, result);
    }

    @Test
    public void testCounterWithSingleCharacter() {
        Map<Character, Integer> result = symbolFrequency.counter("a");
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        assertEquals(expected, result);
    }

    @Test
    public void testCounterWithManyCharacters() {
        Map<Character, Integer> result = symbolFrequency.counter("ffffffsssswwww aaaaaabbb");
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 6);
        expected.put('f', 6);
        expected.put('s', 4);
        expected.put('w', 4);
        expected.put('b', 3);
        expected.put(' ', 1);
        assertEquals(expected, result);
    }

    @Test
    public void testCounterWithMixedCaseCharacters() {
        SymbolFrequency symbolFrequency = new SymbolFrequency();
        Map<Character, Integer> result = symbolFrequency.counter("aAAbBbB");
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('A', 2);
        expected.put('b', 2);
        expected.put('B', 2);
        expected.put('a', 1);
        assertEquals(expected, result);
    }
    @Test
    public void testCounterWithNullInputString() {

        StringIsNull thrown = Assertions.assertThrows(StringIsNull.class, () -> {
            symbolFrequency.counter(null);
        });

        Assertions.assertEquals("Input string is null", thrown.getMessage());
    }

}