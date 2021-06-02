package com.huilong.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/2/18 20:13
 * @Author: DengHuiLong
 * @Description: 子集
 * 回溯
 * 时间复杂度：O(n*2n)
 * 空间复杂度：O(n)
 */
public class SubSets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, nums, temp, ans);
        return ans;
    }

    private static void dfs(int depth, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        dfs(depth + 1, nums, temp, ans);

        temp.add(nums[depth]);
        dfs(depth + 1, nums, temp, ans);
        temp.remove(temp.size() - 1);
    }
}
