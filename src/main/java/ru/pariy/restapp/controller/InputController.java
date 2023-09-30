package ru.pariy.restapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pariy.restapp.service.SymbolFrequency;

import java.util.Map;

@RestController
@RequestMapping("/data")
public class InputController {
    SymbolFrequency symbolFrequency;

    /**
     * POST-метод, который принимает строку в теле запроса (RequestBody) и находит частоту символов в этой строке.
     * Возвращает объект Map<Character, Integer>, в котором ключами являются символы из входной строки,
     * а значениями — количество их повторений в строке.
     *
     * @param text Строка, для которой нужно найти частоту символов. Не должна быть null.
     * @return Объект Map<Character, Integer>, содержащий частоту символов во входной строке.
     */
    @PostMapping()
    public Map<Character, Integer> getData(@RequestBody String text) {
        symbolFrequency = new SymbolFrequency();
        System.out.println(ResponseEntity.ok(HttpStatus.OK));
        Map<Character, Integer> result = symbolFrequency.counter(text);
        System.out.println(result);
        return result;
    }
}
