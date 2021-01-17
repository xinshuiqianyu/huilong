package com.huilong.interview.algorithm.geek.stack;

/**
 * @Date: 2020/11/22 17:07
 * @Author: DengHuiLong
 * @Description: 栈的压入、弹出序列
 */
public class ValidateStackSequencesDemo {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>(5);
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
