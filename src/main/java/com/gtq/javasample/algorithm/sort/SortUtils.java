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
        heapSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 };
        heapSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1000 , 1, 45, 4, 6, 90, 90, 434};
        heapSort(array);
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

    public static void heapSort(int[] array) {
        int size = array.length;
        buildHeap(array, size);
        for (int i = size - 1; i > 0; i--) {
            swap(array, i, 0);
            adjustHeap(array, 0, i);
        }
    }


    private static void adjustHeap(int[] array, int index, int size) {
        int lChildIndex = index * 2 + 1;
        int rChildIndex = index * 2 + 2;
        int max = index;
        if (index < size / 2) {
            if (lChildIndex < size && array[max] < array[lChildIndex]) {
                max = lChildIndex;
            }
            if (rChildIndex < size && array[max] < array[rChildIndex]) {
                max = rChildIndex;
            }

            if (max != index) {
                swap(array, max, index);
                adjustHeap(array, max, size);
            }
        }
    }

    private static void buildHeap(int[] array, int size) {
        for (int i = size / 2; i >= 0; i--) {
            adjustHeap(array, i, size);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
