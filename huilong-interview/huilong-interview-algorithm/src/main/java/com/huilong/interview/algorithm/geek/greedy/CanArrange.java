package com.huilong.interview.algorithm.geek.greedy;

/**
 * @Date: 2021/1/10 15:32
 * @Author: DengHuiLong
 * @Description: 检查数组对是否可以被 k 整除
 * https://leetcode-cn.com/problems/check-if-array-pairs-are-divisible-by-k/
 */
public class CanArrange {

    public static boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for (int num : arr) {
            ++mod[(num % k + k) % k];
        }
        for (int i = 1; i <= k >> 1; i++) {
            // 哈希映射中键 t(t>0) 和键 k−t 对应的值相等
            if (mod[i] != mod[k - 1]) {
                return false;
            }
        }
        // 哈希映射中键 0 对应的值为偶数
        return mod[0] % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        System.out.println(canArrange(arr, 5));
    }
}
