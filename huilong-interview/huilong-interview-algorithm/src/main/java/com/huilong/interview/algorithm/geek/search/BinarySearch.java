package com.huilong.interview.algorithm.geek.search;

/**
 * @Date: 2020/12/16 22:48
 * @Author: DengHuiLong
 * @Description: 搜索旋转排序数组
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = search(nums, 6);
        System.out.println(search);
    }
}
