package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class WindowMain {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(15)
                .window(3);
    }
}
