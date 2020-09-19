package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    public static void main(String[] args) {
        String[] strings = {"One", "Two", "Three", "Four", "Five"};

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length() - left.length();
        };

        Arrays.sort(strings, cmpDescSize);
    }
}