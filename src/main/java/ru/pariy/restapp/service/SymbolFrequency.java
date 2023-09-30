package ru.pariy.restapp.service;

import java.util.*;

public class SymbolFrequency {
    /**
     * Метод, который находит частоту символов во входной строке и возвращает объект Map<Character, Integer>,
     * в котором ключами являются символы из строки, а значениями — количество их повторений в строке.
     * @param string - Входная строка, в которой нужно найти частоту символов. Не должна быть null.
     * @return Объект Map<Character, Integer>, содержащий частоту символов из входной строки.
     * @throws StringIsNull Если входная строка (string) равна null.
     */
    public Map<Character, Integer> counter(String string) {
        if (string == null) {
            throw new StringIsNull("Input string is null");
        } else {
            Map<Character, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < string.length(); i++) {
                Character character = string.charAt(i);
                Integer value = frequencyMap.get(character);
                if (value == null) {
                    frequencyMap.put(character, 1);
                } else {
                    frequencyMap.put(character, value + 1);
                }
            }
            return sortByValue(frequencyMap);
        }
    }

    /**
     * Метод для сортировки объекта Map<Character, Integer> по значениям (частоте символов) в убывающем порядке.
     * @param map Объект Map<Character, Integer>, который нужно отсортировать.
     * @return Отсортированный объект Map<Character, Integer> по убыванию частоты символов.
     */
    private Map<Character, Integer> sortByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }


}
