package com.huilong.interview.algorithm.geek.sort;

/**
 * @Date: 2020/12/12 14:08
 * @Author: DengHuiLong
 * @Description: 快排
 */
public class QuickSort {

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);

        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 6, 2};
        System.out.println(arr);
        quickSort(arr, 6);
        System.out.println(arr);
    }
}
