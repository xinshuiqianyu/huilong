package com.huilong.interview.algorithm.sort.compare;

import java.util.Set;
import java.util.TreeMap;

/**
 * @Date: 2020/10/18 16:07
 * @Author: DengHuiLong
 * @Description:
 */
public class ComparableDemo {

    public static void main(String[] args) {
        TreeMap<Person, String> pdata = new TreeMap<Person, String>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }
    }
}
