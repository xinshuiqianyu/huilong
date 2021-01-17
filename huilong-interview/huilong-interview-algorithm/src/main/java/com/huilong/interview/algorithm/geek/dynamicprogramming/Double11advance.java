package com.huilong.interview.algorithm.geek.dynamicprogramming;

/**
 * @Date: 2021/1/12 23:47
 * @Author: DengHuiLong
 * @Description: 动态规划：双 11 凑单满减
 */
public class Double11advance {

    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][w * 3 + 1];
        states[0][0] = true;
        if (items[0] <= w * 3) {
            states[0][items[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w * 3; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j <= w * 3 - items[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + items[i]] = true;
                }
            }
        }

        int j;
        for (j = w; j <= w * 3; j++) {
            if (states[n - 1][j]) {
                break;
            }
        }

        if (j == w * 3 + 1) {
            return;
        }

        for (int i = n - 1; i >= 1; i--) {
            if (j - items[i] > 0 && states[i - 1][j - items[i - 1]]) {
                System.out.println(items[i] + " ");
            }
            j = j - items[i];
        }

        if (j != 0) {
            System.out.println(items[0]);
        }
    }
}
