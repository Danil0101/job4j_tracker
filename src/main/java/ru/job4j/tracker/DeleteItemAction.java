package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id item: ");
        if (tracker.delete(id)) {
            out.println("Operation completed");
        } else {
            out.println("Operation failed");
        }
        return true;
    }
}
