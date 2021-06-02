package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/11 13:00
 * @Author: DengHuiLong
 * @Description: 最长回文子串
 */
public class LongestPalindrome {

    // 时间复杂度：O(n3)
    // 空间复杂度：O(1)
    public static String longestPalindromeByForce(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int begin = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (valid(chars, i, j) && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private static boolean valid(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String longestPalindromeByDp(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        boolean[][] states = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            states[i][i] = true;
        }

        int begin = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    states[i][j] = false;
                } else {
                    if (j - i < 3) {
                        states[i][j] = true;
                    } else {
                        states[i][j] = states[i + 1][j - 1];
                    }
                }

                if (j - i + 1 > maxLen && states[i][j]) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        String ans = longestPalindromeByDp(s);
        System.out.println(ans);

    }
}
