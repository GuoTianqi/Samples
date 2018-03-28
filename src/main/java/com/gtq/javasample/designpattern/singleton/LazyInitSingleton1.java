package com.gtq.javasample.designpattern.singleton;

/**
 * 延迟初始化单例
 */
public class LazyInitSingleton1 {
    private static LazyInitSingleton1 INSTANCE;
    /**
     * 默认构造方法为private，避免用户用new构造出新对象
     */
    private LazyInitSingleton1() {}

    /**
     * 获取单例的静态工厂同步方法
     * 延迟初始化单例
     * 使用同步方法保证多线程操作只实例化一个实力
     * @return LazyInitSingleton1 单例
     */
    public synchronized static LazyInitSingleton1 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyInitSingleton1();
        }

        return INSTANCE;
    }

    public void someMethod() {}

    public static void main(String[] args) {
        Singleton2.getInstance().someMethod();
    }
}
