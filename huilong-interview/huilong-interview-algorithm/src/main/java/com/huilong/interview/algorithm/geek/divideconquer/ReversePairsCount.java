package com.huilong.interview.algorithm.geek.divideconquer;

/**
 * @Date: 2021/1/10 21:52
 * @Author: DengHuiLong
 * @Description: 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairsCount {

    private static int num = 0;

    public static int reversePairs(int[] a) {
        num = 0;
        mergeSortCount(a, 0, a.length - 1);
        return num;
    }

    private static void mergeSortCount(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortCount(a, p, q);
        mergeSortCount(a, q + 1, r);
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
                num += q - i + 1;
                tmp[k++] = a[j++];
            }
        }

        while (i <= q) {
            tmp[k++] = a[i++];
        }

        while (j <= r) {
            tmp[k++] = a[j++];
        }

        for (i = 0; i < r - p + 1; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {7,5,6,4};
    }
}
