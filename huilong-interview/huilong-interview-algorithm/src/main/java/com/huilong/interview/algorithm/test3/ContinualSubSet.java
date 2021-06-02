package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/5/30 21:03
 * @Author: DengHuiLong
 * @Description: 实现函数, 给定一个字符串数组, 求该数组的连续非空子集，分別打印出来各子集 ，举例数组为[abc]，输出[a],[b],[c],[ab],[bc],[abc]
 */
public class ContinualSubSet {

    public static List<String> continualSubSet(char[] chars) {
        List<String> ans = new ArrayList<>();
        if (chars.length == 0) {
            return ans;
        }
        dfs(chars, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void dfs(char[] chars, List<String> ans, List<Character> tmp, int index) {
        if (index == chars.length) {
            if (!tmp.isEmpty()) {
                ans.add(String.valueOf(tmp));
            }
            return;
        }

        dfs(chars, ans, tmp, index + 1);

        if (index == 0 || tmp.get(tmp.size() - 1) == chars[index - 1]) {
            tmp.add(chars[index]);
            dfs(chars, ans, tmp, index + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        List<String> ans = continualSubSet(chars);
        System.out.println(ans);
    }
}
