package com.plahotin.wordfrequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsFrequency {

    public static void main(String[] args) {
        String text = "";
        countWords(text).entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(entry -> String.format("%s : %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }


    public static Map<String, Long> countWords(String text) {
        TreeMap map = new TreeMap();
        String[] splittedText = text.replaceAll("\\p{Punct}", "").replaceAll("\n", " ").split(" ");
        return Arrays.stream(splittedText).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
