package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortItemsAscending() {
        List<Item> items = Arrays.asList(
                new Item(3),
                new Item(1),
                new Item(5)
        );
        Collections.sort(items, new SortItemsAscending());
        assertEquals(1, items.get(0).getId());
        assertEquals(3, items.get(1).getId());
        assertEquals(5, items.get(2).getId());
    }

    @Test
    public void sortItemsDescending() {
        List<Item> items = Arrays.asList(
                new Item(3),
                new Item(1),
                new Item(5)
        );
        Collections.sort(items, new SortItemsDescending());
        assertEquals(5, items.get(0).getId());
        assertEquals(3, items.get(1).getId());
        assertEquals(1, items.get(2).getId());
    }
}