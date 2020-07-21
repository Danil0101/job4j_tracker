package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ======";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askInt("Enter Id item: "));
        if (item != null) {
            System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
