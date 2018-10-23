package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.List;

public class BufferMain {
    public static void main(String[] args) {
        Observable<List<Integer>> observable = Observable.just(1, 2, 3, 4, 5)
                .buffer(3, 3)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe");
                    }
                });
        Consumer<List<Integer>> consumer = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                System.out.println("buffer size: " + integers.size());
                System.out.println("buffer value:");
                for (Integer i : integers) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        };
        observable.subscribe(consumer);
        observable.subscribe(consumer);
    }
}
