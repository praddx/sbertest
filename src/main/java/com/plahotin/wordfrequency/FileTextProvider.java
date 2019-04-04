package com.plahotin.wordfrequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTextProvider implements TextProvider{

    private String filePath;

    FileTextProvider(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public String getText() {
        String result = "";
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            result = lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
