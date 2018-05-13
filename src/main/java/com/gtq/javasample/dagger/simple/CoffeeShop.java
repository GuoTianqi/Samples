package com.gtq.javasample.dagger.simple;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = DripCoffeeModule.class)
public interface CoffeeShop {
    CoffeeMaker marker();
}
