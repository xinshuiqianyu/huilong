package com.huilong.interview.algorithm.test;

/**
 * @Date: 2021/2/18 17:35
 * @Author: DengHuiLong
 * @Description:
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        char[] winFreq = new char[128];
        char[] tFreq = new char[128];
        for (char charT : charArrayT) {
            tFreq[charT]++;
        }

        // 滑动窗口字符串包含目标字符的个数
        int distance = 0;
        int begin = 0;
        int minLen = sLen + 1;

        // [left, right)
        int left = 0;
        int right = 0;
        while (right < sLen) {
            char winRight = charArrayS[right];
            if (tFreq[winRight] == 0) {
                right++;
                continue;
            }
            if (winFreq[winRight] < tFreq[winRight]) {
                distance++;
            }
            winFreq[winRight]++;
            right++;

            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char winLeft = charArrayS[left];
                if (tFreq[winLeft] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[winLeft] == charArrayT[winLeft]) {
                    distance--;
                }
                winFreq[winLeft]--;
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }

        return s.substring(begin, begin + minLen);
    }

}
