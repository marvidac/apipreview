package com.example.building_exercise.model.enums;

public enum AccessTypeEnum {

    ADMINISTRATOR("Administrator"),
    REGULAR_USER("Regular User") ;
    private String value;

    private AccessTypeEnum(String value) {
        this.value = value;
    }

    public boolean isEquals(String value) {
        return this.value.equalsIgnoreCase(value);
    }
}
