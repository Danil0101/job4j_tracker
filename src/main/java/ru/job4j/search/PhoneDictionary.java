package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containedInName = (p) -> p.getName().contains(key);
        Predicate<Person> containedInSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> containedInPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> containedInAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = containedInName.or(containedInSurname).or(containedInPhone).or(containedInAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
