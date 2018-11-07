package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

import java.util.concurrent.atomic.AtomicInteger;

public class DeferredDependent {
    public static void main(String[] args) {
        final AtomicInteger count = new AtomicInteger();

        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                .andThen(Single.just(count.get()))
                .subscribe(System.out::println);

        final AtomicInteger count1 = new AtomicInteger();
        // Observable.range(1, 10)
        Observable.error(new RuntimeException("Hello World"))
                .doOnNext(ignored -> count1.incrementAndGet())
                .ignoreElements()
                .andThen(Single.defer(() -> Single.just(count1.get())))
                .subscribe(new Consumer<Integer>() {
                               @Override
                               public void accept(Integer integer) throws Exception {
                                   System.out.println("count = " + integer);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                System.out.println("error count = " + count1.toString());
                                throwable.printStackTrace();
                            }
                        });
    }
}
