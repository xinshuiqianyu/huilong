package com.huilong.interview.algorithm.test2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date: 2021/3/10 23:48
 * @Author: DengHuiLong
 * @Description: 无重复的最长子串
 */
public class LengthOfLongestSubstring {

    // 滑动窗口法
    // [i, rk] 不重复 则 [i+1, rk] 不重复
    // 时间复杂度：O(n)
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int rk = -1;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
