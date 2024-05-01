package com.example.building_exercise.repository;

import com.example.building_exercise.model.User;

public class UserFilters {

    private UserFilters() {}

    protected static boolean filterByUserId(User user, User filter) {
        return  filterIsNull(filter) ||
            null == filter.getUserId() ||
            (
                userIsValid(user) &&
                user.getUserId().equalsIgnoreCase(filter.getUserId())
            );
    }

    protected static boolean filterByFirstName(User user, User filter) {
        return filterIsNull(filter) ||
            null == filter.getFirstName() ||
            (
                userIsValid(user) &&
                user.getFirstName().equalsIgnoreCase(filter.getFirstName())
            );
    }

    protected static boolean filterByLastName(User user, User filter) {
        return filterIsNull(filter) ||
            null == filter.getLastName() ||
            (
                userIsValid(user) &&
                user.getLastName().equalsIgnoreCase(filter.getLastName())
            );
    }

    protected static boolean filterByAccessType(User user, User filter) {
        return filterIsNull(filter) ||
            null == filter.getAccessType() ||
            (
                userIsValid(user) &&
                user.getAccessType().equalsIgnoreCase(filter.getAccessType())
            );
    }

    private static boolean userIsValid(User user) {
        return null != user;
    }

    private static boolean filterIsNull(User filter) {
        return null == filter;
    }
}
