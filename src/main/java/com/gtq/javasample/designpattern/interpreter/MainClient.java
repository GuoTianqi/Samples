package com.gtq.javasample.designpattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainClient {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        Map<String, Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为: " + expStr + " = " + cal.run(var));
    }

    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static Map<String, Integer> getValue(String exprStr) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (char ch : exprStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                System.out.print("请输入" + ch + "的值：");
                if (!map.containsKey(String.valueOf(ch))) {
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }

        return map;
    }
}
