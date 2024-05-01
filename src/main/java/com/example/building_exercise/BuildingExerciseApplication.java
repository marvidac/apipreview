package com.example.building_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class BuildingExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingExerciseApplication.class, args);
    }

}
