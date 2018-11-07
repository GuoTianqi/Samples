package com.gtq.javasample.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Backpressure {
    public static void main(String[] args) {
//        Flowable.range(1, 100_0000)
//                .observeOn(Schedulers.computation())
//                .blockingSubscribe(v -> compute(v), Throwable::printStackTrace);

        Flowable<Integer> flowable = Flowable.just("This doesn't matter")
                .map(ignored -> computeValue());
        flowable.subscribe(new DisposableSubscriber<Integer>() {
            @Override
            protected void onStart() {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("11 value: " + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        flowable.subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    protected void onStart() {
                        request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("value: " + integer);
                        request(1);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static int counter;


    private static int computeValue() {
        return ++counter;
    }

    public static <T> void compute(T value) {
        System.out.println("value: " + value);
//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
