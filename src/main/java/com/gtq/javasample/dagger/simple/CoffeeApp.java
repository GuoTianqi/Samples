package com.gtq.javasample.dagger.simple;

public class CoffeeApp {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = DaggerCoffeeShop.create();
        coffeeShop.marker().brew();
    }
}
