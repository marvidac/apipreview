package com.example.building_exercise.validation;

import com.example.building_exercise.model.User;

public interface ValidationForUser {
    <T extends User> boolean validate(T user);
    UserValidationType getUserValidationType();
}
