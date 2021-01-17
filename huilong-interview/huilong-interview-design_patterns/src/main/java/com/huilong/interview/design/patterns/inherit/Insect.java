package com.huilong.interview.design.patterns.inherit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2020/10/24 20:02
 * @Author: DengHuiLong
 * @Description: 昆虫
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Insect {

    private int size;
    private String color;

    public void move() {
        System.out.println("Move");
    }

    public void attack() {
        move();  //假设昆虫在攻击前必须要先移动一次
        System.out.println("Attack");
    }

}
