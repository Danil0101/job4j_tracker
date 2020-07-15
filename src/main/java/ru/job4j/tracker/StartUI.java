package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.print("Enter Id item: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name item: ");
                Item item = new Item();
                item.setName(scanner.nextLine());
                if (tracker.replace(id, item)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter Id item: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id item: ");
                Item item = tracker.findById(Integer.parseInt(scanner.nextLine()));
                if (item != null) {
                    System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name item: ");
                Item[] items = tracker.findByName(scanner.nextLine());
                for (Item item : items) {
                    System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
