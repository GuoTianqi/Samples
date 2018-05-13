package com.gtq.javasample.designpattern.singleton;

/**
 * 延迟初始化，双重检测，降低同步方法开销
 */
public class LazyInitSingleton3 {
    /**
     * 注意：使用了 volatile 修饰符
     * 保证任何一个线程在读取INSTANCE的时候都将看到最近刚刚被写入的值
     */
    private static volatile LazyInitSingleton3 INSTANCE;
    private LazyInitSingleton3() {}
    public static LazyInitSingleton3 getInstance() {
        // 第一次判断无需同步，如果 INSTANCE 已经被初始化，
        // 就直接返回，没有同步开销
        if (INSTANCE == null) {
            // 如果判断为空（多线程并发执行 getInstance，导致很多线程判断外层INSTANCE == NULL）
            synchronized (LazyInitSingleton3.class) {
                // 进入同步后再判断一次，
                // 保证只有一个线程赋值给 INSTANCE，
                // 后续进来执行的线程都会判断 INSTANCE != NULL，不会再赋值
                if (INSTANCE == null) {
                    INSTANCE = new LazyInitSingleton3();
                }
            }
        }

        return INSTANCE;
    }
}
