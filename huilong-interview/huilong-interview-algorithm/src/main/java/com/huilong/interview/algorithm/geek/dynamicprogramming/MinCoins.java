package com.huilong.interview.algorithm.geek.dynamicprogramming;

/**
 * @Date: 2021/1/13 23:46
 * @Author: DengHuiLong
 * @Description: 动态规划，硬币找零
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
 * 如果我们要支付 w 元，求最少需要多少个硬币。
 */
public class MinCoins {

    public static int minCoins(int money) {

        if (money == 1 || money == 3 || money == 5) {
            return 1;
        }

        boolean[][] states = new boolean[money][money + 1];
        if (money >= 1) {
            states[0][1] = true;
        }
        if (money >= 3) {
            states[0][3] = true;
        }
        if (money >= 5) {
            states[0][5] = true;
        }

        for (int i = 1; i < money; i++) {
            for (int j = 1; j <= money; j++) {
                if (states[i - 1][j]) {
                    if (j + 1 <= money) {
                        states[i][j + 1] = true;
                    }
                    if (j + 3 <= money) {
                        states[i][j + 3] = true;
                    }
                    if (j + 5 <= money) {
                        states[i][j + 5] = true;
                    }
                    if (states[i][money]) {
                        return i + 1;
                    }
                }
            }
        }

        return money;
    }
}
