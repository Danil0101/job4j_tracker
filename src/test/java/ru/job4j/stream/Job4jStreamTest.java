package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Job4jStreamTest {

    @Test
    public void shouldGreaterThanZero() {
        List<Object> actual = new Job4jStream
                .Of(-2, -1, 0, 1, 2, 3)
                .filter(o -> (int) o > 0)
                .collect();
        List<Object> expected = List.of(1, 2, 3);
        assertThat(actual, is(expected));
    }
}