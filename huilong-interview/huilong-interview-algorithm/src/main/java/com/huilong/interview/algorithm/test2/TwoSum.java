package com.huilong.interview.algorithm.test2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/3/10 21:25
 * @Author: DengHuiLong
 * @Description: 两数之后
 */
public class TwoSum {

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length-1);
        map.put(nums[0], 0);
        for (int i=1; i<length; i++) {
            int index = target - nums[i];
            if (map.containsKey(index)) {
                return new int[] {map.get(index), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
