package com.huilong.interview.design.patterns.combination;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date: 2020/10/24 20:16
 * @Author: DengHuiLong
 * @Description:
 */
@Data
@AllArgsConstructor
class AttackImpl implements Attack {

    private String move;
    private String attack;

    @Override
    public void move() {
        System.out.println(move);
    }

    @Override
    public void attack() {
        move();
        System.out.println(attack);
    }

}


