package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class WindowMain {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1500, TimeUnit.MICROSECONDS)
                .take(15)
                .window(3)
                .subscribe(longObservable -> {
                    longObservable.subscribe(aLong -> System.out.println(aLong));
                });

        Thread.sleep(20000);
    }
}
