package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4)
                .join(Observable.just("a", "b", "c", "d"),
                        new Function<Integer, ObservableSource<String>>() {
                            @Override
                            public ObservableSource<String> apply(Integer integer) throws Exception {
                                return Observable.just("Hello World");//.delay(1, TimeUnit.SECONDS);
                            }
                        },
                        new Function<String, ObservableSource<String>>() {
                            @Override
                            public ObservableSource<String> apply(String s) {
                                return Observable.just("ooooo");
                            }
                        },
                        new BiFunction<Integer, String, String>() {
                            @Override
                            public String apply(Integer integer, String s) throws Exception {
                                return "join result: " + integer + s;
                            }
                        });
    }
}
