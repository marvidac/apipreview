package com.example.building_exercise.validation;

import com.example.building_exercise.model.User;
import com.example.building_exercise.model.enums.AccessTypeEnum;

import java.util.regex.Pattern;

public enum UserValidationEnum implements ValidationForUser {
    USER_ID(UserValidationType.USER_ID) {
        public <T extends User> boolean validate(T input) {
            String regexForUserId = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(regexForUserId);
            return null != input &&
                    null != input.getUserId() &&
                    pattern.matcher(input.getUserId()).matches();
        }
    },
    PASSWORD(UserValidationType.PASSWORD) {
        public <T extends User> boolean validate(T input) {
            String regexForPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,40}$";
            return null != input &&
                    null != input.getPassword() &&
                    input.getPassword().matches(regexForPassword);
        }
    },
    ACCESS_TYPE(UserValidationType.ACCESS_TYPE) {
        public <T extends User> boolean validate(T input) {
            return null != input &&
                    null != input.getAccessType() &&
                    (AccessTypeEnum.ADMINISTRATOR.isEquals(input.getAccessType()) ||
                            AccessTypeEnum.REGULAR_USER.isEquals(input.getAccessType()));
        }
    },
    UNSUPPORTED (UserValidationType.UNSUPPORTED) {
        public <T extends User> boolean validate(T input) {
            return false;
        }
    };

    private UserValidationType userValidationType;

    private UserValidationEnum(UserValidationType validationType) {
        this.userValidationType = validationType;
    }

    public UserValidationType getUserValidationType() {
        return userValidationType;
    }
}
