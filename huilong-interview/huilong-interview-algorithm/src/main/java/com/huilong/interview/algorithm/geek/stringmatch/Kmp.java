package com.huilong.interview.algorithm.geek.stringmatch;

/**
 * @Date: 2021/1/9 15:48
 * @Author: DengHuiLong
 * @Description: 字符串匹配算法 KMP
 * 时间复杂度 O(n+m)
 * 空间复杂度 O(m)
 */
public class Kmp {

    /**
     * 字符串匹配算法 KMP
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return 匹配时的主串起始下标
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] nexts = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && a[i] != b[j]) {
                j = nexts[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 获取失效函数 nexts
     *
     * @param b 模式串
     * @param m 模式串长度
     * @return 失效函数
     */
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'p', 'c', 'd', 'w', 'e'};
        char[] b = {'c', 'd', 'w'};
        int index = kmp(a, 7, b, 3);
        System.out.println(index);
    }
}
