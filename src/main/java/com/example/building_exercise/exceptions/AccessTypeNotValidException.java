package com.example.building_exercise.exceptions;

public class AccessTypeNotValidException extends RuntimeException  {
    public AccessTypeNotValidException(String message) {
        super(message);
    }
}
