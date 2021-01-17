package com.huilong.interview.algorithm.geek.backtracking;

/**
 * @Date: 2021/1/11 22:08
 * @Author: DengHuiLong
 * @Description: 回溯算法，正则匹配
 */
public class Pattern {

    private boolean matched = false;
    private char[] pattern;
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) {
        matched = false;
        rematch(0, 0, text, tlen);
        return matched;
    }

    private void rematch(int ti, int pj, char[] text, int tlen) {
        if (matched) {
            return;
        }
        if (pj == plen) {
            if (ti == tlen) {
                matched = true;
            }
            return;
        }

        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen - ti; k++) {
                rematch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            rematch(ti, pj + 1, text, tlen);
            rematch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rematch(ti + 1, pj + 1, text, tlen);
        }
    }
}
