package com.example.building_exercise.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    @Serial private static final long serialVersionUID = 8383551255460517062L;

    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String accessType;

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String firstName, String lastName, String accessType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessType = accessType;
    }
    public User(String userId, String firstName, String lastName, String password, String accessType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accessType = accessType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserId().split("@")[0], user.getUserId().split("@")[0]);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
