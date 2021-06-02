package com.huilong.interview.algorithm.test;

/**
 * @Date: 2021/3/6 14:28
 * @Author: DengHuiLong
 * @Description: 排序大汇总
 */
public class Sort {

    // 冒泡排序，比较和交换
    // 时间复杂度：O(n2)
    // 空间复杂度：O(1)，原地排序
    // 冒泡排序是稳定的排序算法
    public void bubbleSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

    // 插入排序
    // 时间复杂度：O(n2)
    // 空间复杂度：O(1)，原地排序
    // 插入排序是稳定的排序算法
    public void insertionSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    // 移动数据
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }

    // 选择排序
    public void selectionSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    // 归并排序
    public void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= p && j <= r) {
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
    public void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = i; j < r; j++) {
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

    // 堆排
    public static void heapSort(int[] a, int n) {
        buildHeap(a, n);
        // 排序
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
            if (i == maxPos) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 8, 5, 7, 6, 2, 9, 5};
        heapSort(a, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
