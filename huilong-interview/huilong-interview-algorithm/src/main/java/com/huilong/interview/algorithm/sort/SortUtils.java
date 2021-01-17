package com.huilong.interview.algorithm.sort;

/**
 * @Date: 2020/10/17 20:47
 * @Author: DengHuiLong
 * @Description: 排序工具类
 */
public class SortUtils {

    /**
     * 冒泡排序
     *
     * @param attr 排序数组
     */
    public static void bubbleSort(int[] attr) {
        if (attr != null && attr.length > 2) {
            int temp = 0;
            for (int i = 0; i < attr.length - 1; i++) {
                for (int j = 0; j < attr.length - 1 - i; j++) {
                    if (attr[j] > attr[j + 1]) {
                        temp = attr[j];
                        attr[j] = attr[j + 1];
                        attr[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param attr 排序数组
     * @param low  开始时最左边的索引=0
     * @param high 开始时最右边的索引=arr.length-1
     */
    public static void quickSort(int[] attr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }

        i = low;
        j = high;
        temp = attr[low];

        while (i < j) {
            while (temp <= attr[j] && i < j) {
                j--;
            }
            while (temp >= attr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = attr[i];
                attr[i] = attr[j];
                attr[j] = t;
            }
        }

        attr[low] = attr[i];
        attr[i] = temp;

        quickSort(attr, low, j - 1);
        quickSort(attr, j + 1, high);
    }

}
