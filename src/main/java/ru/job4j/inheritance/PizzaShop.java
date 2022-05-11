package ru.job4j.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        System.out.println(new Pizza().name());
        System.out.println(new PizzaExtraCheese().name());
        System.out.println(new PizzaExtraCheeseExtraTomato().name());
    }
}
