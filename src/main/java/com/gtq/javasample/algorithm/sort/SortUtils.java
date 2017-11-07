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
                System.out.println("===== " + method.getName() + " =====");
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

    public static void quickSort(int[] array) {
        quickSortInner(array, 0, array.length - 1);
    }

    private static void quickSortInner(int[] array, int low, int high) {
        if (low < high) {
            int loc = quickSortPartition(array, low, high);
            quickSortInner(array, 0, loc - 1);
            quickSortInner(array, loc + 1, high);
        }
    }

    private static int quickSortPartition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            // 找出小于pivot的数
            while (low < high && array[high] > pivot) {
                high--;
            }
            array[low] = array[high];

            // 找出大于pivot的数
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }

        array[low] = pivot;

        return low;
    }

    public static void mergeSort(int[] array) {
        for (int gap = 1; gap < array.length; gap = 2 * gap) {
            groupMerge(array, gap);
        }
    }

    /**
     * 分组合并
     */
    private static void groupMerge(int[] array, int gap) {
        int i = 0;
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < array.length; i = i + 2 * gap) {
            merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }

        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < array.length) {
            merge(array, i, i + gap - 1, array.length - 1);
        }
    }

    /**
     * 合并
     */
    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] tmpArray = new int[high - low + 1];
        int k = 0;
        // 遍历第一段和第二段数组，知道有一个遍历完
        while (i <= mid && j <= high) {
            // 比较哪个最小，存入临时数组，继续遍历，直到到达其中一个数组边界
            if (array[i] <= array[j]) {
                tmpArray[k] = array[i];
                i++;
            } else {
                tmpArray[k] = array[j];
                j++;
            }
            k++;
        }

        // 将第一段没有遍历完的元素存入临时数组
        while (i <= mid) {
            tmpArray[k] = array[i];
            i++;
            k++;
        }

        // 将第二段没有遍历完的元素存入临时数组
        while (j <= high) {
            tmpArray[k] = array[j];
            j++; 
            k++;
        }

        // 将有序的临时数组复制到原始数组中
        for (i = 0; i < tmpArray.length; i++) {
            array[low + i] = tmpArray[i];
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
