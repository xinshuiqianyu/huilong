package com.huilong.interview.design.patterns.inherit;

/**
 * @Date: 2020/10/24 20:04
 * @Author: DengHuiLong
 * @Description: 蜜蜂
 */
public class Bee extends Insect {

    public Bee(int size, String color) {
        super(size, color);
    }

    @Override
    public void move() {
        System.out.println("Fly");
    }

    @Override
    public void attack() {
        move();
        super.attack();
    }

}
