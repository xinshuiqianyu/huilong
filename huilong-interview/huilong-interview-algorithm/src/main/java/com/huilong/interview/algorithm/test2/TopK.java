package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/23 21:46
 * @Author: DengHuiLong
 * @Description: 长度为N的有重复元素的数组，要求输出第10大的数。
 */
public class TopK {
    public static int topK(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (k - 1 == pivot) {
                return nums[pivot];
            }
            if (k - 1 < pivot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int tmp = nums[right];
        nums[right] = nums[i];
        nums[i] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 12, 3, 5, 15, 1, 8, 8, 19};
        System.out.println(topK(a, 10));
    }
}
