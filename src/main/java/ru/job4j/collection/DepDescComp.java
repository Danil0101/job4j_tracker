package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String dep1 = o1.split("/")[0];
        String dep2 = o2.split("/")[0];
        if (dep1.equals(dep2)) {
            return o1.compareTo(o2);
        } else {
            return o2.compareTo(o1);
        }
    }
}
