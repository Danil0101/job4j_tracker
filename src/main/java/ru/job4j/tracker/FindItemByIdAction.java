package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askInt("Enter Id item: "));
        if (item != null) {
            out.println("Id: " + item.getId() + ", Name: " + item.getName());
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
