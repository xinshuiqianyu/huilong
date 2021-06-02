package com.huilong.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/2/8 22:04
 * @Author: DengHuiLong
 * @Description: 全排列
 * 回溯算法
 * 时间复杂度：O(n*n!)
 * 空间复杂度：O(n*n!)
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 1) {
            return ans;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] use = new boolean[length];

        dfs(nums, length, 0, path, use, ans);
        return ans;
    }

    private static void dfs(int[] nums, int length, int depth, List<Integer> path, boolean[] use, List<List<Integer>> ans) {
        if (depth == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!use[i]) {
                use[i] = true;
                path.add(nums[i]);
                dfs(nums, length, depth + 1, path, use, ans);
                // 回溯发生在从 深结点 回到 浅结点的过程，代码在形式上和递归之前是对称的
                use[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
