package com.example.building_exercise.service;

import com.example.building_exercise.exceptions.UserIdNotValidException;
import com.example.building_exercise.model.User;
import com.example.building_exercise.repository.UserRepository;
import com.example.building_exercise.validation.UserValidation;
import com.example.building_exercise.validation.UserValidationEnum;
import com.example.building_exercise.validation.UserValidationType;
import com.example.building_exercise.validation.ValidationForUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Value( "${message.invalid.userId}" )
    String userIdInvalidMessage;
    @Value( "${message.invalid.password}" )
    String passwordInvalidMessage;
    @Value( "${message.invalid.accessType}" )
    String accessTypeInvalidMessage;

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String userId) {
        validateFilter(new User(userId));
        List<User> users = userRepository.filter(new User(userId));

        if(null != users && !users.isEmpty())
            return users.get(0);

        return null;
    }

    public List<User> filter(User filter) {
        validateFilter(filter);
        return userRepository.filter(filter);
    }

    private void validateFilter(User filter) {
        List<ValidationForUser> validationsForUser = buildValidationsToExecute(filter);

        UserValidation userValidations = new UserValidation(validationsForUser);

        userValidations.execute(filter).stream().forEach(typeNotValid -> {
           if(typeNotValid.equals(UserValidationType.USER_ID))
               throw new UserIdNotValidException(userIdInvalidMessage);

           if(typeNotValid.equals(UserValidationType.PASSWORD))
               throw new UserIdNotValidException(passwordInvalidMessage);

           if(typeNotValid.equals(UserValidationType.ACCESS_TYPE))
               throw new UserIdNotValidException(accessTypeInvalidMessage);
        });
    }

    private List<ValidationForUser> buildValidationsToExecute(User filter) {
        List<ValidationForUser> validationsForUser = new ArrayList<>();

        if(null != filter) {
            if(null != filter.getUserId()) validationsForUser.add(UserValidationEnum.USER_ID);
            if(null != filter.getPassword()) validationsForUser.add(UserValidationEnum.PASSWORD);
            if(null != filter.getAccessType()) validationsForUser.add(UserValidationEnum.ACCESS_TYPE);
        }

        return validationsForUser;
    }

}
