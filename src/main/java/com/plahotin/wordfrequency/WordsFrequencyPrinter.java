package com.plahotin.wordfrequency;

import java.util.*;
import java.util.stream.Collectors;

public class WordsFrequencyPrinter {

    public static void main(String[] args) {
        TextProvider textProvider = new FileTextProvider("src/main/java/resources/Text.txt");
        String text = textProvider.getText();
        if (!text.isEmpty()) {
            String[] preparedText = prepareText(text);
            Map<String, Long> wordsFrequencyAnalysisResult = analyzeWordsFrequency(preparedText);
            printWordsFrequencyAnalysis(wordsFrequencyAnalysisResult);
        } else {
            System.out.println("Переданные данные не содержат слов.");
        }
    }

    public static void printWordsFrequencyAnalysis(Map<String, Long> analysisResult) {
        analysisResult.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingLong(Map.Entry::getValue)))
                .map(entry -> String.format("%-20s : %20s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }

    public static String[] prepareText(String text) {
        return text.replaceAll("[!@#$%^&*?()\"'.,\\[\\]{}\\d\\t]", "")
                .replaceAll(" - ", " ")
                .replaceAll("\\n", " ")
                .toLowerCase()
                .split(" ");
    }

    public static Map<String, Long> analyzeWordsFrequency(String[] preparedText) {
        return Arrays.stream(preparedText).filter(s -> !s.isEmpty()).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
