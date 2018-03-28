package com.gtq.javasample.designpattern.singleton;

/**
 * lazy initialization holder class 模式
 * 避免同步方法的开销
 */
public class LazyInitSingleton2 {
    private static class SingletonHolder {
        static final LazyInitSingleton2 field = computeFieldValue();
        private static LazyInitSingleton2 computeFieldValue() {
            return new LazyInitSingleton2();
        }
    }

    private LazyInitSingleton2() {}
    public static LazyInitSingleton2 getInstance() {
        return SingletonHolder.field;
    }
}
