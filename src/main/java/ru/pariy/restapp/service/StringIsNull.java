package ru.pariy.restapp.service;

public class StringIsNull extends RuntimeException {
    public StringIsNull(String message) {
        super(message);
    }
}
