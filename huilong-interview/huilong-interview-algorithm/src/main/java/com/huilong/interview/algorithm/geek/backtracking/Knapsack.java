package com.huilong.interview.algorithm.geek.backtracking;

/**
 * @Date: 2021/1/11 22:30
 * @Author: DengHuiLong
 * @Description: 回溯算法，0-1 背包
 */
public class Knapsack {

    // 存储背包中物品总重量的最大值
    public int maxW = Integer.MIN_VALUE;

    /**
     * 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
     * f(0, 0, a, 10, 100)
     *
     * @param i     表示考察到哪个物品了
     * @param cw    表示当前已经装进去的物品的重量和
     * @param items 表示每个物品的重量
     * @param n     表示物品个数
     * @param w     背包重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w表示装满了; i==n表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }

        // 不装
        f(i + 1, cw, items, n, w);

        // 装
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
