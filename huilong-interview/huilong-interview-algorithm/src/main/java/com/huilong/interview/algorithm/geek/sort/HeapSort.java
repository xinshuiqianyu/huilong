package com.huilong.interview.algorithm.geek.sort;

/**
 * @Date: 2020/12/26 12:01
 * @Author: DengHuiLong
 * @Description: 堆排，堆元素从下标 1 开始
 */
public class HeapSort {

    /**
     * 堆排：1-建堆，2-排序
     *
     * @param a a
     * @param n n
     */
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    /**
     * 建堆
     *
     * @param a a
     * @param n n
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n >> 1; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆化
     *
     * @param a 数组
     * @param n 大小
     * @param i 堆化结点位置
     */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i == maxPos) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 交换位置
     *
     * @param a a
     * @param i i
     * @param j j
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 8, 5, 7, 6, 2, 9, 5};
        sort(a, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
