package com.gtq.javasample.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class CreateObservable {
    public static void main(String[] args) {
        customObservableBlocking().subscribe(System.out::println);
    }

    public static Observable<String> customObservableBlocking() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < 50; i++) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext("ｖalue_" + i);
                    }
                }

                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });
    }
}
