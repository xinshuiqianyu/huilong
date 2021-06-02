package com.huilong.interview.algorithm.test3;

/**
 * @Date: 2021/4/10 9:19
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
                    ++i;
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

    // 无序数组中的 第K大数
    public static int KthMax(int[] a, int target) {
        if (a == null || a.length < target) {
            return -1;
        }

        int pivot = partition(a, 0, a.length - 1);
        while (target - 1 != pivot) {
            if (target - 1 < pivot) {
                pivot = partition(a, 0, pivot - 1);
            } else {
                pivot = partition(a, pivot + 1, a.length - 1);
            }
        }

        return a[pivot];
    }

    public static void main(String[] args) {
        int[] a = {0, 8, 5, 7, 6, 2, 9, 5};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        int[] a1 = {4, 2, 5, 12, 3};
        System.out.println(KthMax(a1, 3));
    }
}
