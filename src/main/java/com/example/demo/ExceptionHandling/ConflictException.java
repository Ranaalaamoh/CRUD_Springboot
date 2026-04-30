package com.example.demo.ExceptionHandling;



public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}