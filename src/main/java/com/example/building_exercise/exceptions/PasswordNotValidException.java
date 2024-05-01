package com.example.building_exercise.exceptions;

public class PasswordNotValidException extends RuntimeException  {
    public PasswordNotValidException(String message) {
        super(message);
    }
}
