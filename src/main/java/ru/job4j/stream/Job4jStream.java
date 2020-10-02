package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Job4jStream {
    private List<Object> list;

    public static class Of {
        private Job4jStream jStream;

        public Of(Object... objects) {
            jStream = new Job4jStream();
            jStream.list = new ArrayList<>(Arrays.asList(objects));
        }

        public Of filter(Predicate<Object> predicate) {
            List<Object> newList = new ArrayList<>();
            for (Object o : jStream.list) {
                if (predicate.test(o)) {
                    newList.add(o);
                }
            }
            jStream.list = newList;
            return this;
        }

        public List<Object> collect() {
            return jStream.list;
        }
    }
}