package com.huilong.interview.algorithm.geek.dynamicprogramming;

/**
 * @Date: 2021/1/13 23:15
 * @Author: DengHuiLong
 * @Description: 动态规划，矩阵最小距离
 * 动态规划
 * 一个模型，三个特性
 * 多阶段决策最优解模型
 * 最优子结构
 * 无后效性
 * 重复子问题
 */
public class MinDist {
    public static int minDist(int[][] matrix, int n) {

        int[][] states = new int[n][n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }

        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i - 1][j], states[i][j - 1]);
            }
        }

        return states[n-1][n-1];
    }
}
