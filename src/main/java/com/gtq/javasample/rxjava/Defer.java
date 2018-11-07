package com.gtq.javasample.rxjava;

import io.reactivex.Observable;

public class Defer {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.defer(() -> {
            long time = System.currentTimeMillis();
            return Observable.just(time);
        });

        observable.subscribe(time -> System.out.println(time));

        Thread.sleep(1000);

        observable.subscribe(time -> System.out.println(time));
    }
}
