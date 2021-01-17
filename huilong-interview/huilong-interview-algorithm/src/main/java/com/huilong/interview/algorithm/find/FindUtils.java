package com.huilong.interview.algorithm.find;

/**
 * @Date: 2020/10/19 22:49
 * @Author: DengHuiLong
 * @Description: 查找工具类
 */
public class FindUtils {

    /**
     * 二分查找：时间复杂度 O(log2n) (以2为底，n为对数)
     *
     * @param array  查找数组
     * @param target 查找的目标值
     * @return 目标所在的索引位置
     */
    public static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;

            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 一个【本来排好序了的 且为升序】的数组，然后又在某个不知道的位置旋转了一下，
     * 所谓旋转，就是把前面那堆数移到后面来了，求新数组的最小值。
     * 原 array：[0, 1, 2, 4, 5, 6, 7]
     * rotate 之后就是：[4, 5, 6, 7, 0, 1, 2]，[5, 6, 7, 0, 1, 2, 4]
     * 输出：最小值 0
     * 要求 时间复杂度 O(log2n) (以2为底，n为对数)
     * 元素不重复
     *
     * @param array 查找的数组
     * @return 数组中最小值
     */
    public static int findMid(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return array[left];
    }

    /**
     * 元素重复：[3, 3, 1, 3]
     * @param array 查找的数组
     * @return 数组中最小值
     */
    public static int findMidWithDuplicate(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                right--;
            } else {
                right = mid;
            }
        }

        return array[left];
    }

}
