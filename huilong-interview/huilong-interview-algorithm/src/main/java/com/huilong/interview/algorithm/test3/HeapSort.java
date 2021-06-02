package com.huilong.interview.algorithm.test3;

import java.util.Arrays;

/**
 * @Date: 2021/5/11 23:30
 * @Author: DengHuiLong
 * @Description: 堆排
 */
public class HeapSort {

    public static void heapSort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, k, 1);
            k--;
            heapify(a, k, 1);
        }
    }

    // 建堆
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    // 堆化
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 5, 4, 2, 3, 9, 1};
        heapSort(a, 6);
        System.out.println(Arrays.toString(a));
    }
}
