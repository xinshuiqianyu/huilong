package com.huilong.interview.algorithm.test;

/**
 * @Date: 2021/3/7 11:36
 * @Author: DengHuiLong
 * @Description: O(n) 时间复杂度内求无序数组中的第 K 大元素
 */
public class KthMax {

    private static int kthMax(int[] a, int n, int k) {
        if (a == null || n < k) {
            return -1;
        }

        int pivot = partition(a, 0, n - 1);
        while (pivot != k - 1) {
            if (pivot < k - 1) {
                pivot = partition(a, pivot + 1, n - 1);
            } else {
                pivot = partition(a, 0, pivot - 1);
            }
        }

        return a[pivot];
    }

    // 分区
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 12, 3};
        System.out.println(kthMax(a,5,4));
    }
}
