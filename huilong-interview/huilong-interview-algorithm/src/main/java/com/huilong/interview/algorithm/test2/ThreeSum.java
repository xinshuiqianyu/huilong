package com.huilong.interview.algorithm.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2021/3/13 23:26
 * @Author: DengHuiLong
 * @Description: 三数之和（a+b+c=0）
 * 排序
 * 遍历
 * 大于0，break
 * nums[i] == nums[i-1]，continue
 * 等于0，l+1 = l, l++
 * 等于0，r-1 = r, r--
 * l++, r--
 * 小于0，l++
 * 大于0，r--
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
