package com.huilong.interview.design.patterns.combination;

/**
 * @Date: 2020/10/24 21:03
 * @Author: DengHuiLong
 * @Description:
 */
public class CompositionDemo {

    public static void main(String[] args) {

        CombinationBee combinationBee1 =
                new CombinationBee(1, "black", new AttackImpl("fly", "move"));
        combinationBee1.attack();

        CombinationBee combinationBee2 =
                new CombinationBee(1, "black", new AttackImpl("fly", "sting"));
        combinationBee2.attack();
    }
}
