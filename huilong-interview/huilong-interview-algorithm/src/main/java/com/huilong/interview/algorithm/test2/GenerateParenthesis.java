package com.huilong.interview.algorithm.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/3/14 12:33
 * @Author: DengHuiLong
 * @Description: 生成括号
 * 回溯
 * 剪枝：左括号小于 n，添加；右括号小于左括号，添加。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, StringBuffer s, int open, int close, int n) {
        if (s.length() == n * 2) {
            ans.add(s.toString());
            return;
        }
        if (open < n) {
            s.append('(');
            dfs(ans, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(')');
            dfs(ans, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
