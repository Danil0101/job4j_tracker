package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class DeleteAllAction implements UserAction {

    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete all items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        tracker.findAll().clear();
        out.println("Items are successfully deleted!");
        return true;
    }
}
