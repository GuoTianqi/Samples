package com.gtq.javasample.designpattern.singleton;

/**
 * 公有静态成员是个final域
 * 直接引用成员获取单例
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    /**
     * 默认构造方法为private，避免用户用new构造出新对象
     */
    private Singleton1() {}

    public void someMethod() {}

    public static void main(String[] args) {
        Singleton1.INSTANCE.someMethod();
    }
}
