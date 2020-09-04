package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final String ln = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItemAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Exit" + ln
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item1"));
        Item item2 = tracker.add(new Item("Item2"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new AllItemsAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Show all items" + ln +
                        "1. Exit" + ln +
                        "Id: " + item1.getId() + ", Name: " + item1.getName() + ln +
                        "Id: " + item2.getId() + ", Name: " + item2.getName() + ln +
                        "Menu." + ln +
                        "0. Show all items" + ln +
                        "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        String itemName = "itemName";
        Input in = new StubInput(
                new String[] {"0", itemName, "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item(itemName));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Find item by name" + ln +
                        "1. Exit" + ln +
                        "Id: " + item.getId() + ", Name: " + item.getName() + ln +
                        "Menu." + ln +
                        "0. Find item by name" + ln +
                        "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("itemName"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIdAction(output));
        actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit" + ln +
                        "Id: " + item.getId() + ", Name: " + item.getName() + ln +
                        "Menu." + ln +
                        "0. Find item by Id" + ln +
                        "1. Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "1", "0" }
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}