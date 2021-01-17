package com.huilong.interview.algorithm.geek.dynamicprogramming;

import static org.apache.commons.lang3.math.NumberUtils.min;

/**
 * @Date: 2021/1/14 22:30
 * @Author: DengHuiLong
 * @Description: 编辑距离，莱温斯坦距离
 */
public class LwstDp {

    public static int lwsDP(char[] a, int n, char[] b, int m) {

        int[][] minDist = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            } else if (j != 0) {
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                } else {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
                }
            }
        }

        return minDist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'd', 'r', 'w'};
        char[] b = {'a', 'r', 'w', 'd', 'w'};
        System.out.println(lwsDP(a, 5, b, 5));
        ;
    }
}
