package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
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
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
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
        UserAction[] actions = {
                new ReplaceItemAction(output),
                new ExitProgramAction(output)
        };
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
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitProgramAction(output)
        };
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
        UserAction[] actions = {
                new ExitProgramAction(output)
        };
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
        UserAction[] actions = {
                new AllItemsAction(output),
                new ExitProgramAction(output)
        };
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
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitProgramAction(output)
        };
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
        UserAction[] actions = {
                new FindItemByIdAction(output),
                new ExitProgramAction(output)
        };
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
}