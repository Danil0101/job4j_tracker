package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String numStrLeft = "";
        String numStrRight = "";
        int numLeft;
        int numRight;
        for (int i = 0; i < left.length(); i++) {
            int curNumericValue = Character.getNumericValue(left.charAt(i));
            if (curNumericValue >= 0 && curNumericValue <= 9) {
                numStrLeft += curNumericValue;
            } else {
                break;
            }
        }
        for (int i = 0; i < right.length(); i++) {
            int curNumericValue = Character.getNumericValue(right.charAt(i));
            if (curNumericValue >= 0 && curNumericValue <= 9) {
                numStrRight += curNumericValue;
            } else {
                break;
            }
        }
        try {
            numLeft = Integer.parseInt(numStrLeft);
        } catch (NumberFormatException e) {
            numLeft = Integer.MAX_VALUE;
        }
        try {
            numRight = Integer.parseInt(numStrRight);
        } catch (NumberFormatException e) {
            numRight = Integer.MAX_VALUE;
        }
        return Integer.compare(numLeft, numRight);
    }
}