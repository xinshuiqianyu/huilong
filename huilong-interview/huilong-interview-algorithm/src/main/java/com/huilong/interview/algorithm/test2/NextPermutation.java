package com.huilong.interview.algorithm.test2;


import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @Date: 2021/3/14 16:55
 * @Author: DengHuiLong
 * @Description: 下一个排列
 */
public class NextPermutation {

    // 倒序遍历，较小数，较大数，交换，倒序
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;    // 较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;    // 较大数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);   // 交换
        }
        reverse(nums, i + 1);   // 反转
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(nums);
    }
}
