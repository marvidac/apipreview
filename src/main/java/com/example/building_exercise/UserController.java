package com.example.building_exercise;

import com.example.building_exercise.model.User;
import com.example.building_exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") String id) {
        User returnedUser = userService.findById(id);

        return ResponseEntity
                .ok()
                .body(returnedUser);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<User>> findUsers(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String accessType) {
        List<User> listOfUsers = userService.filter(
                new User(userId, firstName, lastName, password, accessType));

        return ResponseEntity
                .ok()
                .body(listOfUsers);
    }

}
