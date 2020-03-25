package com.gtq.faith.java;

/**
 * Created by guotianqi on 2017/8/27.
 */
public class JavaSingleton {
    private static JavaSingleton INSTANCE;
    private JavaSingleton() {}

    public static JavaSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JavaSingleton();
        }

        return INSTANCE;
    }

    public static void doSomethins() {

    }
}
