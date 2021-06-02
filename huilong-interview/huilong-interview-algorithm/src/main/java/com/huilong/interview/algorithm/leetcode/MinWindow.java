package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/18 17:08
 * @Author: DengHuiLong
 * @Description: 最小覆盖子串
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部包含多少 T 中的字符，对应字符频数超过不重复计算
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] == 0) {
                right++;
                continue;
            }
            if (winFreq[charRight] < tFreq[charRight]) {
                distance++;
            }
            winFreq[charRight]++;
            right++;

            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                if (tFreq[charLeft] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[charLeft] == tFreq[charLeft]) {
                    distance--;
                }
                winFreq[charLeft]--;
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }
}
