package com.gtq.javasample;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Java7NewFeature {
    public static void main(String[] args) {
        List<String> stuff = new ArrayList<>();

        for (String s : args) {
            stuff.add(s);
        }
        stuff.forEach((s) -> System.out.println(s));
        Lambda<String> lambda = new Lambda<>();
        lambda.apply(stuff, s -> {
                    System.out.println(s);
                    System.out.println(s);
                }
        );

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("working " + i + " seconds");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }).start();
    }

    public static class Lambda<T> {
        public void apply(@NotNull List<T> list, @NotNull Action<T> action) {
            for (T t: list) {
                action.perform(t);
            }
        }
    }

    interface Action<T> {
        public void perform(T t);
        default void change() {

        }
    }
}
