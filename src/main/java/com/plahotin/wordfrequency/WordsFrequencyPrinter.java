package com.plahotin.wordfrequency;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsFrequencyPrinter {

    private TextProvider textProvider;

    public WordsFrequencyPrinter(TextProvider textProvider) {
        this.textProvider = textProvider;
    }

    public static void main(String[] args) {
        String text = "всем привет. как поживаете? \n как дела? привет привет, привет. Так-то. 12 3. Это - это то.";

        printWordsFrequency(text);
    }

    public static void printWordsFrequency(String text) {
        //String text = textProvider.getText();
        String[] preparedText = prepareText(text);
        Map<String, Long> wordFrequencyMap = countFrequency(preparedText);
        wordFrequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingLong(Map.Entry::getValue)))
                .map(entry -> String.format("%-20s : %20s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }

    public static String[] prepareText(String text) {
        return text.replaceAll("[!@#$%^&*?()\"'.,\\[\\]{}]|\\d", "")
                .replaceAll(" - ", " ")
                .replaceAll("\\n", " ")
                .toLowerCase()
                .split(" ");
    }

    public static Map<String, Long> countFrequency(String[] preparedText) {
        //TreeMap map = new TreeMap();
        //String[] splittedText = text.replaceAll("\\p{Punct}", "").replaceAll("\n", " ").split(" ");
        return Arrays.stream(preparedText).filter(s -> !s.isEmpty()).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public void fullStreamExecution(String text) {
        Optional.ofNullable(text).map(s -> s.replaceAll("\\p{Punct}", ""))
                .map(s -> s.replaceAll("\n", " "))
                .map(s -> s.split(" "))
                .map(Arrays::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> String.format("%s : %s", entry.getKey(), entry.getValue()))
                .forEach(s -> System.out.println(s));

    }
}
