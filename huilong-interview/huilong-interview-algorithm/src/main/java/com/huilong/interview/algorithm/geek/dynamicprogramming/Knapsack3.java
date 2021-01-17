package com.huilong.interview.algorithm.geek.dynamicprogramming;

import java.util.Arrays;

/**
 * @Date: 2021/1/12 22:57
 * @Author: DengHuiLong
 * @Description: 动态规划：背包问题
 */
public class Knapsack3 {

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(states[i], -1);
        }

        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        int maxValue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxValue) {
                maxValue = states[n - 1][j];
            }
        }
        return maxValue;
    }
}
