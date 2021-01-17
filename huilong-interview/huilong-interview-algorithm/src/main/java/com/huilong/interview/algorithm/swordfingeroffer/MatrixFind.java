package com.huilong.interview.algorithm.swordfingeroffer;

/**
 * @Date: 2020/10/27 23:36
 * @Author: DengHuiLong
 * @Description: https://github.com/CyC2018/CS-Notes/blob/master/notes/4.%20%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E6%9F%A5%E6%89%BE.md
 * <p>
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * <p>
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 */
public class MatrixFind {

    public static boolean find(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;

        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(find(matrix, 5));
    }

}
