package com.gtq.javasample.rxjava;

import io.reactivex.Flowable;

public class Generate {
    public static void main(String[] args) {
        final int startValue = 1;
        final int incrementValue = 1;
        Flowable<Integer> flowable = Flowable.generate(() -> startValue, (s, emitter) -> {
           int nextValue = s + incrementValue;
           emitter.onNext(nextValue);
           return nextValue;
        });

        flowable.take(10).subscribe(value -> System.out.println(value));
    }
}
