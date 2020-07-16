package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ====");
                for (Item item : tracker.findAll()) {
                    System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = input.askInt("Enter Id item: ");
                Item item = new Item();
                item.setName(input.askStr("Enter new name item: "));
                if (tracker.replace(id, item)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = input.askInt("Enter Id item: ");
                if (tracker.delete(id)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                Item item = tracker.findById(input.askInt("Enter Id item: "));
                if (item != null) {
                    System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                Item[] items = tracker.findByName(input.askStr("Enter name item: "));
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
                    }
                } else {
                    System.out.println("No applications found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("0. Add new Item" + System.lineSeparator()
                            + "1. Show all items" + System.lineSeparator()
                            + "2. Edit item" + System.lineSeparator()
                            + "3. Delete item" + System.lineSeparator()
                            + "4. Find item by Id" + System.lineSeparator()
                            + "5. Find items by name" + System.lineSeparator()
                            + "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
