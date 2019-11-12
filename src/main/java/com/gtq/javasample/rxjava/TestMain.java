package com.gtq.javasample.rxjava;

import com.gtq.javasample.util.Log;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        Log.d("Thread: " + Thread.currentThread().getName());
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                Log.d("subscribe");
//                Log.d("Thread: " + Thread.currentThread().getName());
//                if (!emitter.isDisposed()) {
//                    emitter.onNext("Hello");
//                    emitter.onNext("World");
//                    emitter.onNext("!");
//                    emitter.onComplete();
//                }
//            }
//        })
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        Log.d("doOnSubscribe");
//                        Log.d("Thread: " + Thread.currentThread().getName());
//                    }
//                })
//                .subscribeOn(Schedulers.single())
//                //.subscribeOn(Schedulers.io())
//                // .observeOn(Schedulers.computation())
//                .observeOn(Schedulers.computation())
//                .switchMapCompletable(new Function<String, CompletableSource>() {
//                    @Override
//                    public CompletableSource apply(String s) throws Exception {
//                        return Completable.create(new CompletableOnSubscribe() {
//                            @Override
//                            public void subscribe(CompletableEmitter emitter) throws Exception {
//                                System.out.println("flat thread: " + Thread.currentThread());
//                                emitter.onComplete();
//                            }
//                        });
//                    }
//                })
//                .subscribe(new Action() {
//            @Override
//            public void run() throws Exception {
//                System.out.println("run = " + Thread.currentThread());
//            }
//        });
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d("onSubscribe");
//                        Log.d("Thread: " + Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d("onNext: " + s);
//                        Log.d("Thread: " + Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("onError: " + e.toString());
//                        Log.d("Thread: " + Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("onComplete");
//                        Log.d("Thread: " + Thread.currentThread().getName());
//                    }
//                });


//        Log.d("XXX:" + Observable.interval(2, 1, TimeUnit.SECONDS)
//                .blockingFirst());
//        Log.d("END");
//        Thread.sleep(4000);

        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> emitter) throws Exception {
//                 emitter.onComplete();
                emitter.onSuccess("Hello World!");
            }
        }).observeOn(Schedulers.computation())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("Thread: " + Thread.currentThread().getName());
                        System.out.println("result = Complete");
                    }
                })
                .doOnSuccess(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("Thread: " + Thread.currentThread().getName());
                        System.out.println("result = " + s);
                    }
                }).subscribe();

        Thread.sleep(4000);
    }
}
