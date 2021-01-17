package com.huilong.interview.algorithm.geek.dynamicprogramming;

import static org.apache.commons.lang3.math.NumberUtils.max;

/**
 * @Date: 2021/1/14 23:24
 * @Author: DengHuiLong
 * @Description: 编辑距离，最长公共子串
 */
public class LcsDp {

    public static int lcs(char[] a, int n, char[] b, int m) {

        int[][] maxLcs = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                maxLcs[0][j] = 1;
            } else if (j != 0) {
                maxLcs[0][j] = maxLcs[0][j - 1];
            } else {
                maxLcs[0][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                maxLcs[i][0] = 1;
            } else if (i != 0) {
                maxLcs[i][0] = maxLcs[i - 1][0];
            } else {
                maxLcs[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    maxLcs[i][j] = max(maxLcs[i - 1][j - 1] + 1, maxLcs[i - 1][j], maxLcs[i][j - 1]);
                } else {
                    maxLcs[i][j] = max(maxLcs[i - 1][j - 1], maxLcs[i - 1][j], maxLcs[i][j - 1]);
                }
            }
        }

        return maxLcs[n - 1][m - 1];
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'd', 'r', 'w'};
        char[] b = {'a', 'r', 'w', 'd', 'w'};
        System.out.println(lcs(a, 5, b, 5));

    }
}
