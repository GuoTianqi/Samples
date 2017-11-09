package com.gtq.javasample.algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static List<String> getFullPermutation(String str) {
        List<String> list = new ArrayList<>();
        innerFullPerm(list, str.toCharArray(), 0);
        return list;
    }

    private static void innerFullPerm(List<String> list, char[] str, int start) {
        if (start == str.length - 1) {
            list.add(String.valueOf(str));
            return;
        }

        for (int i = start; i < str.length; i++) {
            swap(str, i, start);
            innerFullPerm(list, str, start + 1);
            swap(str, i, start);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        List<String> list = getFullPermutation("abc");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
