package com.huilong.interview.algorithm.duplication;

/**
 * @Date: 2020/10/22 23:24
 * @Author: DengHuiLong
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8
 * 来源：牛客网
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] numbers = {6, 3, 2, 0, 2, 5, 0};
        /*int dup = findDup(numbers, numbers.length);
        System.out.println(dup);*/

        int dup2 = findDup2(numbers);
        System.out.println(dup2);
    }


    public static int findDup(int[] numbers, int length) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                return index;
            }
            numbers[index] = numbers[index] + length;
        }
        return -1;
    }

    public static int findDup2(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                swap(numbers, numbers[i], i);
            }
        }
        return -1;
    }

    public static void swap(int[] numbers, int i, int j) {
        int t = i;
        i = j;
        j = t;
    }
}
