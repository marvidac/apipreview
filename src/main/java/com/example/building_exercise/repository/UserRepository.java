package com.example.building_exercise.repository;

import com.example.building_exercise.model.User;
import com.example.building_exercise.util.FileResourceUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> filter(User filter){
        return buildListOfUsers().stream()
                .filter(user -> UserFilters.filterByUserId(user, filter))
                .filter(user -> UserFilters.filterByFirstName(user, filter))
                .filter(user -> UserFilters.filterByLastName(user, filter))
                .filter(user -> UserFilters.filterByAccessType(user, filter))
                .sorted(Comparator.comparing(User::getFirstName))
                .toList();
    }

    private List<User> buildListOfUsers() {
        List<User> users = new ArrayList<>();
        String[] allUsersFromFile = FileResourceUtil.getContentFromFile("users.txt");

        Arrays.stream(allUsersFromFile).map(user -> {
            String[] userValues = user.split(";");
            return new User(userValues[0], userValues[2], userValues[1], userValues[3].replace("\r",""));
        }).forEach(users::add);

        return users;
    }
}
