package com.gtq.javasample.dagger.simple;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DripCoffeeModule {
    @Provides @Singleton static Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides static Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
