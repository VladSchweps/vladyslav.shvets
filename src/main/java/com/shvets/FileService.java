package com.shvets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileService {
    public String readFile(Path filePath) {
        try {
            return new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + e);
        }
    }

    public void writeToFile(Path path, String text) {
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            throw new RuntimeException("Problem with writing: " + e);
        }
    }

    public Path addFileNameAnnotation(Path filePath, String annotation) {
        StringBuilder fileName = new StringBuilder(filePath.getFileName().toString());
        Path dir = filePath.getParent();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            fileName.insert(fileName.lastIndexOf("."), "[" + annotation + "]");
        }
        return dir.resolve(Path.of(fileName.toString()));
    }
}
