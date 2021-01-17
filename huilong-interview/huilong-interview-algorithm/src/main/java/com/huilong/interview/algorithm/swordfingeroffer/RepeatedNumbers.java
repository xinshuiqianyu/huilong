package com.huilong.interview.algorithm.swordfingeroffer;

/**
 * @Date: 2020/10/27 23:04
 * @Author: DengHuiLong
 * @Description: https://github.com/CyC2018/CS-Notes/blob/master/notes/3.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97.md
 * <p>
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * <p>
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。
 */
public class RepeatedNumbers {

    public static int findRepeatedNumber(int[] numbers) {

        if (numbers == null || numbers.length < 1) {
            return -1;
        }

        for (int i = 1; i < numbers.length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }

                swap(numbers, i, numbers[i]);
            }
        }

        return -1;

    }

    public static void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 3, 1, 5, 0};
        System.out.println(findRepeatedNumber(numbers));
    }
}
