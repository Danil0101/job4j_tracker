package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ==========";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id item: ");
        if (tracker.delete(id)) {
            System.out.println("Operation completed");
        } else {
            System.out.println("Operation failed");
        }
        return true;
    }
}
