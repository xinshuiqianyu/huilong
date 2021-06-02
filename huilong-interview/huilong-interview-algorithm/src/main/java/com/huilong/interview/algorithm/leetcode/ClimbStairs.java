package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/13 16:28
 * @Author: DengHuiLong
 * @Description: 爬楼梯
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ClimbStairs {

    // 滚动数组，降低空间复杂度，O(1)
    public static int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    // 不能连续跳两个台阶
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = climbStairs2(45);
        System.out.println(ans);
    }
}
