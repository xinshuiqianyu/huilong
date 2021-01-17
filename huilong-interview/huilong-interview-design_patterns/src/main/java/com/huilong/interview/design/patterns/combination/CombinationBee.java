package com.huilong.interview.design.patterns.combination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2020/10/24 20:19
 * @Author: DengHuiLong
 * @Description: 这个封装类封装了一个Attack类型的对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class CombinationBee extends CombinationInsect implements Attack {

    private Attack attack;

    public CombinationBee(int size, String color, Attack attack) {
        super(size, color);
        this.attack = attack;
    }

    @Override
    public void move() {
        attack.move();
    }

    @Override
    public void attack() {
        attack.attack();
    }

}
