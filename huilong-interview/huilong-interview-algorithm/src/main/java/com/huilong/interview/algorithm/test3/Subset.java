package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/5/30 22:12
 * @Author: DengHuiLong
 * @Description: 实现函数, 给定一个字符串数组, 求该数组的连续非空子集，分別打印出来各子集 ，举例数组为[abc]，输出[a],[b],[c],[ab],[bc],[abc]
 */
public class Subset {

    // 连续非空子数组
    public static List<String> continualSubset(char[] chars) {
        List<String> ans = new ArrayList<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            List<Character> tmp = new ArrayList<>();
            for (int j = i; j < length; j++) {
                tmp.add(chars[j]);
                ans.add(tmp.toString());
            }
        }
        return ans;
    }

    // 非空子数组
    public static List<String> subset(char[] chars) {
        List<String> ans = new ArrayList<>();
        dfs(ans, chars, new ArrayList<>(), 0);
        return ans;
    }

    private static void dfs(List<String> ans, char[] chars, List<Character> tmp, int index) {
        if (index == chars.length) {
            if (!tmp.isEmpty()) {
                ans.add(tmp.toString());
            }
            return;
        }

        dfs(ans, chars, tmp, index + 1);

        tmp.add(chars[index]);
        dfs(ans, chars, tmp, index + 1);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        System.out.println(continualSubset(chars));
        System.out.println(subset(chars));
    }
}
