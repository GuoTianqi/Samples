package com.gtq.javasample.algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class SortUtils {
    public static void main(String[] args) {
        Method[] methods = SortUtils.class.getMethods();
        List<Method> sortMethods = new ArrayList<>();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()) &&
                    method.getName().endsWith("Sort")) {
                sortMethods.add(method);
            }
        }

        Collections.sort(sortMethods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        try {
            for (Method method : sortMethods) {
                System.out.println("===== " + method.getName() + "=====");
                int[] array = new int[0];
                method.invoke(null, array);
                System.out.println(Arrays.toString(array));

                array = new int[]{1000};
                method.invoke(null, array);
                System.out.println(Arrays.toString(array));

                array = new int[]{1000, 1, 45, 4, 6, 90, 90, 434};
                method.invoke(null, array);
                System.out.println(Arrays.toString(array));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接插入排序
     *
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
     *
     * @param array
     */
    public static void shellInsertSort(int[] array) {
        int step = array.length;
        while ((step /= 2) != 0) {
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

    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        int size = array.length;
        buildHeap(array, size);
        for (int i = size - 1; i > 0; i--) {
            swap(array, i, 0);
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j + 1, j);
                }
            }
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
