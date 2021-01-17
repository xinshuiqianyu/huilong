package com.huilong.interview.algorithm.geek.greedy;

/**
 * @Date: 2021/1/10 12:46
 * @Author: DengHuiLong
 * @Description: 避免重复字母的最小删除成本
 * https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class MinCost {
    public int minCost(String s, int[] cost) {
        char[] chars = s.toCharArray();
        int minCost = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                if (cost[i] < cost[i + 1]) {
                    minCost += cost[i];
                } else {
                    minCost += cost[i + 1];
                    cost[i + 1] = cost[i];
                }
            }
        }
        return minCost;
    }
}
