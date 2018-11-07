package com.gtq.javasample.rxjava;

import io.reactivex.Observable;

public class MergeDelayError {
    public static void main(String[] args) {
        Observable<String> observable1 = Observable.error(new IllegalArgumentException(""));
        Observable<String> observable2 = Observable.just("Four", "Five", "Six");
        Observable.mergeDelayError(observable1, observable2)
                .subscribe(item -> System.out.println(item));
    }
}
