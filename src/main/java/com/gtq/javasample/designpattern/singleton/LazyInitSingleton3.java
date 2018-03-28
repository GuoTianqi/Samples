package com.gtq.javasample.designpattern.singleton;

/**
 * 延迟初始化，双重检测，避免降低同步方法开销
 */
public class LazyInitSingleton3 {
    private static volatile LazyInitSingleton3 INSTANCE;
    private LazyInitSingleton3() {}
    public static LazyInitSingleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyInitSingleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyInitSingleton3();
                }
            }
        }

        return INSTANCE;
    }
}
