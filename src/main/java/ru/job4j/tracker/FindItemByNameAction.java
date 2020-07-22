package ru.job4j.tracker;

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
        Item[] items = tracker.findByName(input.askStr("Enter name item: "));
        if (items.length > 0) {
            for (Item item : items) {
                out.println("Id: " + item.getId() + ", Name: " + item.getName());
            }
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
