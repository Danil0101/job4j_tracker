package ru.job4j.tracker;

public class AllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items =======";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("Id: " + item.getId() + ", Name: " + item.getName());
        }
        return true;
    }
}
