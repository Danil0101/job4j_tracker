package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = new Item(input.askStr("Enter name: "));
        tracker.add(item);
        return true;
    }
}
