package com.gtq.javasample.dagger.simple;

import javax.inject.Inject;

public class CoffeeMaker {
    @Inject Heater heater;
    @Inject Pump pump;

    @Inject
    CoffeeMaker() {}

    public void brew() {
        heater.on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.off();
    }
}
