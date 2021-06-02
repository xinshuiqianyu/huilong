package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/13 12:54
 * @Author: DengHuiLong
 * @Description: 不同路径
 * 时间复杂度：O(mn)
 * 空间复杂度：O(mn)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] states = new int[m][n];
        for (int i = 0; i < m; i++) {
            states[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            states[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = states[i - 1][j] + states[i][j - 1];
            }
        }
        return states[m - 1][n - 1];
    }
}
