package ru.job4j.collection;

import java.util.ArrayList;

/**
 * 2. Проверить две строчки на идентичность.
 * Даны две строки. Нужно проверить, что вторая строка
 * получилась методом перестановок символов в первой строке.
 */

public class FreezeStr {
    public static boolean eq(String left, String right) {
        ArrayList<Character> leftList = new ArrayList<>();
        for (char c : left.toCharArray()) {
            leftList.add(c);
        }

        for (char c : right.toCharArray()) {
            if (!leftList.contains(c)) {
                return false;
            }
            leftList.remove(leftList.indexOf(c));
        }
        return true;
    }
}