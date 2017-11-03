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
        shellInsertSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 };
        shellInsertSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 , 1, 45, 4, 6, 90, 90, 434};
        shellInsertSort(array);
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
            int sortingValue = array[i];
            int j = i - 1;
            while (array[j] > sortingValue) {
                // 将前面的大数值移到后面
                array[j + 1] = array[j];
                j--;
                if (j == -1) {
                    break;
                }
            }

            array[j + 1] = sortingValue;
        }
    }

    /**
     * 希尔排序
     * @param array
     */
    public static void shellInsertSort(int[] array) {
        int step = array.length;
        while((step /= 2) != 0) {
            for (int k = 0; k < step; k++) {
                for (int i = k + step; i < array.length; i += step) {
                    int sortingValue = array[i];
                    int j = i - step;
                    while (array[j] > sortingValue) {
                        // 将前面的大数值移到后面
                        array[j + step] = array[j];
                        j -= step;
                        if (j < 0) {
                            break;
                        }
                    }

                    array[j + step] = sortingValue;
                }
            }
        }
    }
}
