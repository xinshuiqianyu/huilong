package com.huilong.interview.algorithm.geek.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2021/1/11 22:44
 * @Author: DengHuiLong
 * @Description: 回溯算法，8 皇后
 * https://leetcode-cn.com/problems/eight-queens-lcci/solution/liang-chong-shi-xian-xiang-xi-tu-jie-mian-shi-ti-2/
 */
public class Nqueens {

    public static List<List<String>> solveNqueens(int n) {
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '*');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(arr, 0, n, res);
        return res;
    }

    private static void dfs(char[][] arr, int x, int n, List<List<String>> res) {
        if (x == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '*') {
                        tmp.append('*');
                    } else {
                        tmp.append('Q');
                    }
                }
                ans.add(tmp.toString());
            }
            res.add(ans);
            return;
        }

        for (int y = 0; y < n; y++) {
            if (check(arr, x, y, n)) {
                arr[x][y] = 'Q';
                dfs(arr, x + 1, n, res);
                arr[x][y] = '*';
            }
        }
    }

    private static boolean check(char[][] arr, int x, int y, int n) {
        for (int i = 0; i < x; i++) {
            if (arr[i][y] == 'Q') {
                return false;
            }
        }

        int i = x - 1;
        int j = y - 1;
        while (i >= 0 && j >= 0) {
            if (arr[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < n) {
            if (arr[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNqueens(4));
    }
}
