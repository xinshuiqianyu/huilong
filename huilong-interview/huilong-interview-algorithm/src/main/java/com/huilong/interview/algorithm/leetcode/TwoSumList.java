package com.huilong.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/2/7 23:40
 * @Author: DengHuiLong
 * @Description: 找出数组中所有满足两个数相加等于目标值的数字对，并返回它们的数组下标
 * 数组中一个元素不能使用两遍
 */
public class TwoSumList {

    public static List<List<Integer>> twoSumList(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> hashtable = new HashMap<>(length);
        hashtable.put(nums[0], 0);
        for (int i = 1; i < length; i++) {
            List<Integer> element = new ArrayList<>();
            int key = target - nums[i];
            if (hashtable.containsKey(key)) {
                element.add(key);
                element.add(nums[i]);
                ans.add(element);
                hashtable.remove(key);
            } else {
                hashtable.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 7, 4, 3};
        List<List<Integer>> rep = twoSumList(nums, 8);
        System.out.println(rep);
    }
}
