package com.huilong.interview.algorithm.test;

/**
 * @Date: 2021/2/6 21:59
 * @Author: DengHuiLong
 * @Description: 归并排序
 * 稳定排序（原地排序）
 * 时间复杂度 O（nlogn）
 * 空间复杂度 O（n）
 */
public class MergeSort {

    public static void mergeSort(int[] a, int n) {
        mergeInternally(a, 0, n - 1);
    }

    private static void mergeInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergeInternally(a, p, q);
        mergeInternally(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 6, 2};
        System.out.println(arr);
        mergeSort(arr, 6);
        System.out.println(arr);
    }
}
