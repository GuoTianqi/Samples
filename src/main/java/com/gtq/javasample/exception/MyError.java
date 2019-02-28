package com.gtq.javasample.exception;

import java.util.Arrays;
import java.util.List;

public class MyError {
    public static void main(String[] args) {
        try {
            throw new IllegalStateException("测试错误");
        } catch (Exception e) {
            Error error = new Error("OOOOOO", e);
            error.printStackTrace();
            System.out.println("===========");
//            e.printStackTrace();
            System.out.println("===========");
//            System.out.println(e.toString());
            System.out.println("===========");
//            System.out.println(e.getMessage());
        }

        String[] words = {"ace", "boom", "crew", "dog", "eon"};

        List<String> wordList = Arrays.asList(words);

        for (String e : wordList) {
            System.out.println(e);
        }
    }
}
