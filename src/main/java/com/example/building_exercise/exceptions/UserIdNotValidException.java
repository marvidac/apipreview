package com.example.building_exercise.exceptions;

public class UserIdNotValidException extends RuntimeException  {
    public UserIdNotValidException(String message) {
        super(message);
    }
}
