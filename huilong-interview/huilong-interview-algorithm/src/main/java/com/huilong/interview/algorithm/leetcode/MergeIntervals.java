package com.huilong.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2021/2/13 11:45
 * @Author: DengHuiLong
 * @Description: 合并区间
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int end = merged.size() - 1;
            int l = interval[0];
            int r = interval[1];
            if (merged.size() == 0 || merged.get(end)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(end)[1] = Math.max(merged.get(end)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        System.out.println(merged);
    }
}
