package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(-3, -2, -1, 0, 1, 2, 3);
        List<Integer> listRsl = list.stream().filter(i -> i > 0).collect(Collectors.toList());
    }
}
