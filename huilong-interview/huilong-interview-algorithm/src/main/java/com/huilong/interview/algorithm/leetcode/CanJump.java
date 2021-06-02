package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/12 16:23
 * @Author: DengHuiLong
 * @Description: 跳跃游戏
 */
public class CanJump {

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= length-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
