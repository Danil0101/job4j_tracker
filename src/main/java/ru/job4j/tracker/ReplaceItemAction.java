package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id item: ");
        Item item = new Item(input.askStr("Enter new name item: "));
        if (tracker.replace(id, item)) {
            out.println("Operation completed");
        } else {
            out.println("Operation failed");
        }
        return true;
    }
}
