package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/5/30 21:48
 * @Author: DengHuiLong
 * @Description:
 */
public class ContinualSubSet2 {

    public static void main(String[] args) {
        String s = "abc";
        char[] in = s.toCharArray();

        print(in, new StringBuilder(), 0);
        System.out.println();
        print2(s, new StringBuilder());
        System.out.println();
        List<String> ans = print3(s.toCharArray());
        System.out.println(ans);
    }


    public static void print(char[] in, StringBuilder sb, int start) {
        int len = in.length;
        for (int i = start; i < len; i++) {
            sb.append(in[i]);
            System.out.print("[" + sb + "],");
            if (i < len - 1) {
                print(in, sb, i + 1);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public static void print2(String str, StringBuilder sb) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                sb.append("[").append(str, i, j + 1).append("]").append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static List<String> print3(char[] chars) {
        List<String> ans = new ArrayList<>();
        int length = chars.length;
        for (int i=0; i<length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=i; j<length; j++) {
                sb.append(chars[j]);
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
