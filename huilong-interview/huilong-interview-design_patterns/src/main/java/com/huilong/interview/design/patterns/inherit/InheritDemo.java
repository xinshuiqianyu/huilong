package com.huilong.interview.design.patterns.inherit;

/**
 * @Date: 2020/10/24 20:06
 * @Author: DengHuiLong
 * @Description:
 */
public class InheritDemo {

    public static void main(String[] args) {
        Insect i = new Bee(1, "red");
        i.attack();
    }
}
