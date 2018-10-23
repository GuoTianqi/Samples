package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import java.util.List;

public class ReduceMain {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                   @Override
                   public Integer apply(Integer integer, Integer integer2) throws Exception {
                       System.out.println("" + integer + ", " + integer2);
                       return integer + integer2;
                   }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("result = " + integer);
                    }
                });
    }
}
