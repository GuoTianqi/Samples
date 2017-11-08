package com.gtq.javasample.algorithm;

import java.util.Arrays;

public class FibonacciSequence {
    public static void main(String[] args) {
        int length = 20;
        System.out.println("Get Fib Seq (Length = " + length + ":\n" +
                Arrays.toString(getFibSeq(length)));

        for (int i = 0; i < 20; i++) {
            System.out.print(getFibNumByIndex(i) + " ");
        }
        System.out.print("\n");
    }

    /**
     * 获取长度为length的斐波那契数列
     * @param length
     * @return
     */
    public static int[] getFibSeq(int length) {
        if (length == 0) {
            return null;
        }

        int[] fibArr = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                fibArr[i] = 1;
            } else if (i == 1) {
                fibArr[i] = 1;
            } else {
                fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
            }
        }

        return fibArr;
    }

    /**
     * 获取index位置的斐波那契数值
     * @param index
     * @return
     */
    public static int getFibNumByIndex(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }

        return getFibNumByIndex(index - 1) + getFibNumByIndex(index - 2);
    }
}