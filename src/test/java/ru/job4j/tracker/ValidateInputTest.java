package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new ValidateInput(out, new StubInput(
                new String[] {"one", "0"}
        ));
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgramAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), Is.is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Please enter validate data again.%n"
                )
        ));
    }
}