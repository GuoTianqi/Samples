package com.gtq.javasample.rxjava;

import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ParallelProcessing {
    public static void main(String[] args) throws InterruptedException {
//        Flowable.range(1, 10)
//                .observeOn(Schedulers.computation())
//                .map(v -> v * v)
//                .blockingSubscribe(System.out::println);

//        Flowable.range(1, 10)
//                .flatMap(v ->
//                        Flowable.just(v)
//                                .subscribeOn(Schedulers.computation())
//                                .map(w -> w * w)
//                )
//                .blockingSubscribe(System.out::println);
//
        Flowable
                .create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                        System.out.println(Thread.currentThread().toString());
                        for (int i = 0; i < 500; i++) {
                            emitter.onNext(i);
                        }

                        emitter.onComplete();
                    }
                }, BackpressureStrategy.ERROR)
                //.subscribeOn(Schedulers.computation())
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * 1)
                .sequential()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription sub;
                    @Override
                    public void onSubscribe(Subscription s) {
                        sub = s;
                        s.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(Thread.currentThread().toString());
                        System.out.println(integer);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sub.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(5000);

//        Flowable.range(1, 10)
//                .concatMap(v ->
//                        Flowable.just(v)
//                                .subscribeOn(Schedulers.computation())
//                                .map(w -> w * w)
//                )
//                .blockingSubscribe(System.out::println);
    }
}
