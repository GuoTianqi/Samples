package com.gtq.javasample.designpattern.singleton;

/**
 * 一个包含单个元素的枚举类型
 * 枚举类型保证每个枚举常量都是一个单例
 */
public enum EnumSingleton {
    INSTANCE;
    public void someMethod() { /** .... */}

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.someMethod();
    }
}

