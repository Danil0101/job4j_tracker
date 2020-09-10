package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = Character.compare(left.charAt(i), right.charAt(i));
            if (res != 0) {
                break;
            }
            if (i == size - 1 && left.length() != right.length()) {
                res = left.length() > right.length() ? 1 : -1;
            }
        }
        return res;
    }
}