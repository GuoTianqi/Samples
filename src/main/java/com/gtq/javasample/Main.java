package com.gtq.javasample;

import java.awt.*;
import java.net.URI;

/**
 * Created by guotianqi on 2017/7/8.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        assert 1 == 2 : "错误";

        RsaSample.testRsa();

        System.out.println("" + (1 << 9));


        Point point = new Point();
        System.out.println(Point.class.getName());
        if (Point.class.getName().equals(point.getClass().getName())) {
            System.out.println("True");
        }

        System.out.println(Integer.valueOf("89"));
    }
}
