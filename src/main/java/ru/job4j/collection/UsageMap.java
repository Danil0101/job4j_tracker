package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov@yandex.ru", "Ivan Ivanov");
        map.put("Petrov@mail.ru", "Petr Petrov");
        map.put("Danilov@google.com", "Danilov Danil");

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
