package com.huilong.interview.algorithm.test;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @Date: 2021/3/9 21:36
 * @Author: DengHuiLong
 * @Description: 排序练习
 */
public class SortTest {

    // 冒泡排序
    // 时间复杂度：O(n2)；空间复杂度：O(1)；稳定排序
    public static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            boolean haveSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    haveSwap = true;
                }
            }
            if (!haveSwap) {
                break;
            }
        }
    }

    // 插入排序
    // 时间复杂度：O(n2)；空间复杂度：O(1)；稳定排序
    public static void insertSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // 选择排序
    // 时间复杂度：O(n2)；空间复杂度：O(1)；不稳定
    public static void selectSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
                swap(a, i, minIndex);
            }
        }
    }

    // 归并排序
    // 时间复杂度：O(nlogn)；空间复杂度：O(n)；稳定排序
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
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

    // 快速排序
    // 时间复杂度：O(nlogn)；空间复杂度：O(1)；不稳定排序
    // 当数组有序或近似有序，选取数组最后一个数据为分区点，时间复杂度会变成 O(n2)
    // 三数取中，随机
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

    public static int KthMax(int[] a, int n, int k) {
        if (a == null || n < k) {
            return -1;
        }

        int pivot = partition(a, 0, n - 1);
        while (true) {
            if (k - 1 == pivot) {
                return a[pivot];
            }
            if (k - 1 > pivot) {
                pivot = partition(a, pivot + 1, n - 1);
            } else {
                pivot = partition(a, 0, pivot - 1);
            }
        }
    }

    // 堆排
    // 时间复杂度：O(nlogn)；空间复杂度：O(n)
    public static void heapSort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, k, 1);
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
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        int[] a1 = {4, 2, 5, 12, 3};
        System.out.println(KthMax(a1, 5, 2));
    }
}
