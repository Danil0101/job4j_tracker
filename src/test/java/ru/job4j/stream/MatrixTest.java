package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void matrixToList() {
        Integer[][] matrix = new Integer[2][2];
        matrix[0] = new Integer[] {1, 2};
        matrix[1] = new Integer[] {3, 4};
        List<Integer> rsl = Matrix.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}