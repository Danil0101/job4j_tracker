package ru.job4j.tracker;

public class AllItemsAction implements UserAction {
    private final Output out;

    public AllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            out.println("Id: " + item.getId() + ", Name: " + item.getName());
        }
        return true;
    }
}
