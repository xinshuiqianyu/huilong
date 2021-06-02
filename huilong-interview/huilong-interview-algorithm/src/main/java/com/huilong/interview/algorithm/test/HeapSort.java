package com.huilong.interview.algorithm.test;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @Date: 2021/3/9 21:22
 * @Author: DengHuiLong
 * @Description: 堆排：建堆，排序
 */
public class HeapSort {

    public static void sort(int[] a, int n) {
        if (a == null || n < 2) {
            return;
        }
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i * 2] > a[i]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[i * 2 + 1] > a[maxPos]) {
                maxPos = i * 2 + 1;
            }
            if (i == maxPos) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 8, 5, 7, 6, 2, 9, 5};
        sort(a, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
