package com.gtq.javasample;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guotianqi on 2017/7/8.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        assert 1 == 2 : "错误";

        RsaSample.testRsa();

        System.out.println("" + (1 << 9));

        System.out.println(Integer.valueOf("89"));

        List<String> ruleIds = new ArrayList();
        ruleIds.add("1111111111");
        ruleIds.add("2222222222222");
        System.out.println(ruleIds);

        System.out.println("&111&22&&33&".replace("&", "&amp;"));
    }
}
