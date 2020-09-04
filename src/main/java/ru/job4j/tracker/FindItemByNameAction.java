package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findByName(input.askStr("Enter name item: "));
        if (items.size() > 0) {
            for (Item item : items) {
                out.println("Id: " + item.getId() + ", Name: " + item.getName());
            }
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
