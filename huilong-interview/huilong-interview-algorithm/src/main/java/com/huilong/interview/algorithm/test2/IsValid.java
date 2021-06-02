package com.huilong.interview.algorithm.test2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Date: 2021/3/14 9:47
 * @Author: DengHuiLong
 * @Description: 有效括号
 * Deque，栈，先进先出，peek(), pop(), peek(c)
 * map.put('}', '{')
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(c))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
