package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1. Генератор текста
 * Задача большой текст. Из него вырезают слова и предложения. Из них составляют новый текст.
 * Нужно проверить, что новый текст был получен из оригинально.
 */

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> originSet = new HashSet<>(Arrays.asList(origin.split("[\\s,!:.]")));
        HashSet<String> lineSet = new HashSet<>(Arrays.asList(line.split("[\\s,!:.]")));
        for (String word : lineSet) {
            if (!originSet.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
