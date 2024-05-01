package com.example.building_exercise.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileResourceUtil {

    private FileResourceUtil() {}

    public static String[] getContentFromFile(String fileName) {

        try {
            String valuesFromFile = new String(Files.readAllBytes(Paths.get(FileResourceUtil.class.getClassLoader().getResource(fileName).toURI())));
            return valuesFromFile.split("\n");

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
