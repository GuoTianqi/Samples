package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class FlatMapSingle {
    public static void main(String[] args) {
        Observable sourceObservable = Observable.range(1, 10);
        SingleSource<String> someSingleSource = Single.just("Hello World");
        Observable<String> continued = sourceObservable.flatMapSingle(new Function<Integer, SingleSource<?>>() {
            @Override
            public SingleSource<String> apply(Integer integer) throws Exception {
                return someSingleSource;
            }
        });
        continued.subscribe(System.out::println, Throwable::printStackTrace);
    }
}
