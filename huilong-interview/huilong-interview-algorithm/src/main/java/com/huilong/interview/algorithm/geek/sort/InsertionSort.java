package com.huilong.interview.algorithm.geek.sort;

/**
 * @Date: 2020/12/12 15:34
 * @Author: DengHuiLong
 * @Description: 插入排序
 */
public class InsertionSort {

    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 6, 2};
        System.out.println(arr);
        insertionSort(arr, 6);
        System.out.println(arr);
    }
}
