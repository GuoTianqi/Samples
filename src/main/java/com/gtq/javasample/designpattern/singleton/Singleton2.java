package com.gtq.javasample.designpattern.singleton;

/**
 * 公有的成员是个静态工厂方法，通过该方法获取单例
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();
    /**
     * 默认构造方法为private，避免用户用new构造出新对象
     */
    private Singleton2() {}

    /**
     * 获取单例的静态工厂方法
     * @return Singleton2 单例
     */
    public static Singleton2 getInstance() { return INSTANCE; }

    public void someMethod() {}

    public static void main(String[] args) {
        Singleton2.getInstance().someMethod();
    }
}
