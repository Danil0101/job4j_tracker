package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ============";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id item: ");
        Item item = new Item(input.askStr("Enter new name item: "));
        if (tracker.replace(id, item)) {
            System.out.println("Operation completed");
        } else {
            System.out.println("Operation failed");
        }
        return true;
    }
}
