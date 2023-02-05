package com.example.spring_exceptions_demo.error;

public class NoSuchBookException extends RuntimeException {

    public NoSuchBookException(String message) {
        super(message);
    }
}
