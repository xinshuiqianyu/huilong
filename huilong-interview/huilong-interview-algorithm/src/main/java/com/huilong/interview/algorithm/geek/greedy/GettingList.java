package com.huilong.interview.algorithm.geek.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Date: 2021/1/10 20:31
 * @Author: DengHuiLong
 * @Description: 数组中两元素相加等于指定数的所有组合
 * https://www.jianshu.com/p/89c90642bedd
 */
public class GettingList {

    public  static List<ArrayList<Integer>> getList(List<Integer> list, int target) {

        List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        Set<Integer> set = new HashSet<>();
        for (Integer integer : list) {
            ArrayList<Integer> subList = new ArrayList<>();
            int temp = integer;
            if (temp == target) {
                subList.add(temp);
            } else if (set.contains(target - temp)) {
                subList.add(temp);
                subList.add(target - temp);
            }
            set.add(temp);
            if (subList.size() != 0) {
                lists.add(subList);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(3);
        lists.add(5);
        lists.add(4);
        lists.add(2);
        lists.add(7);
        lists.add(6);
        lists.add(4);
        lists.add(3);
        int target = 8;
        System.out.println(getList(lists, target));
    }
}
