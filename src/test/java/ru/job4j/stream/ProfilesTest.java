package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile("Moscow", "Mira", 1, 1));
        profiles.add(new Profile("Kiev", "Mira", 1, 1));
        profiles.add(new Profile("Riga", "Mira", 1, 1));
        profiles.add(new Profile("Kiev", "Mira", 1, 1));
    }

    @Test
    public void getAddressFromProfileAndRemoveDuplicates() {
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                new Address("Kiev", "Mira", 1, 1),
                new Address("Moscow", "Mira", 1, 1),
                new Address("Riga", "Mira", 1, 1)
                );
        assertThat(rsl, is(expected));
    }
}