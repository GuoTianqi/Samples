package com.gtq.javasample.threadsafe;

import java.util.concurrent.TimeUnit;

public class Volatile {
    private static volatile boolean asleep = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (!asleep) {
                    System.out.println("count = " + (count++));
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        asleep = true;

        // thread.join();

        System.out.println("Thread quit");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Jvm Shutdown");
            }
        });
    }
}
