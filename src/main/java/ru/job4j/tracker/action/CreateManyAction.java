package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class CreateManyAction implements UserAction {

    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create many items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int amount_items = input.askInt("How many items to create?: ");
        for (int i = 0; i < amount_items; i++) {
            tracker.add(new Item("name" + i));
        }
        out.println("Added " + amount_items + " items");
        return true;
    }
}
