package com.huilong.interview.algorithm.geek.sort;

/**
 * @Date: 2020/12/12 20:01
 * @Author: DengHuiLong
 * @Description: 计数排序
 */
public class CountingSort {

    private static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中的最大值
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标 [0, max]
        int[] c = new int[max + 1];
        // 计算元素的个数，放入 c 中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }
        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组 r，存储排序之后的结果
        int[] r = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将排序好的结果拷贝到 a 数组中
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 6, 2};
        System.out.println(arr);
        countingSort(arr, 6);
        System.out.println(arr);
    }
}
