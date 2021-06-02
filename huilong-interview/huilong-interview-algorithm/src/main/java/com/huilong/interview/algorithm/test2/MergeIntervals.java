package com.huilong.interview.algorithm.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2021/3/16 23:25
 * @Author: DengHuiLong
 * @Description: 合并区间
 * 排序，判断区间左右端点
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            int end = ans.size() - 1;
            if (ans.size() == 0 || ans.get(end)[1] < l) {
                ans.add(interval);
            } else {
                ans.get(end)[1] = Math.max(ans.get(end)[1], r);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
