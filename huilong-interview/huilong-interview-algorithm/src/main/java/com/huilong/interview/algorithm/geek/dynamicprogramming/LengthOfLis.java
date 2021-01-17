package com.huilong.interview.algorithm.geek.dynamicprogramming;

import java.util.Arrays;

/**
 * @Date: 2021/1/16 10:41
 * @Author: DengHuiLong
 * @Description: 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 * 状态定义：states[i] 的值代表前 i 个数字最长子序列长度
 * 转移方程：states[i] = max(p[i], states[j+1]) for j in [0, i) if nums[i] <= nums[j]
 * 初始状态：states[i] = 1
 * 返回值：states 列表最大值
 * 时间复杂度：O(N2)
 * 空间复杂度：O(N)
 */
public class LengthOfLis {

    public static int lengthOfLis(int[] nums) {
        int length = nums.length;
        int[] states = new int[length];
        int res = 0;
        Arrays.fill(states, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    states[i] = Math.max(states[i], states[j] + 1);
                }
                res = Math.max(res, states[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLis(nums));
    }
}

