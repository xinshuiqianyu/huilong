package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/14 13:34
 * @Author: DengHuiLong
 * @Description: 颜色分类
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class SortColors {

    public static void sortColors1(int[] nums) {
        int length = nums.length;
        int point = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[point];
                nums[point] = temp;
                point++;
            }
        }

        for (int i = point; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[point];
                nums[point] = temp;
                point++;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int length = nums.length;
        int point0 = 0;
        int point1 = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[point1];
                nums[point1] = temp;
                point1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[point0];
                nums[point0] = temp;
                if (point0 < point1) {
                    temp = nums[i];
                    nums[i] = nums[point1];
                    nums[point1] = temp;
                }
                point0++;
                point1++;
            }
        }
    }
}
