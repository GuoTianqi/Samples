package com.gtq.javasample.algorithm.sort;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 */
public class SortUtils {
    public static void main(String[] args) {
        int[] array = new int[0];
        straightInsertSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 };
        straightInsertSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 , 1, 45, 4, 6, 90, 90, 434};
        straightInsertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 直接插入排序
     * @param array
     */
    public static void straightInsertSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public static void shellInsertSort(int[] array) {
        int step = array.length;
        while((step /= 2) != 0) {
            for (int i = step; i < array.length; i += step) {
                for (int j = i; j > 0; j -= step) {
                    if (array[j] < array[j - ])
                }
            }
        }
    }
}
