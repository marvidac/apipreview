package com.example.building_exercise.validation;

import com.example.building_exercise.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    private List<ValidationForUser> validationsForUser;

    public UserValidation(List<ValidationForUser> validationsForUser) {
        this.validationsForUser = validationsForUser;
    }

    public List<UserValidationType> execute(User filter) {
        List<UserValidationType> invalidTypesFromFilter = new ArrayList<>();

        validationsForUser.stream().forEach(validation -> {
            if (!validation.validate(filter)) {
                invalidTypesFromFilter.add(validation.getUserValidationType());
            }
        });

        return invalidTypesFromFilter;
    }
}
