package com.huilong.interview.algorithm.geek.stack;

/**
 * @Date: 2020/11/22 16:51
 * @Author: DengHuiLong
 * @Description: 栈
 */
public class Stack<T> {
    // 数组
    private T[] items;
    // 栈中元素个数
    private int count;
    // 栈的大小
    private int n;

    // 初始化数组，申请一个大小为 n 的数组空间
    public Stack(int n) {
        this.items = (T[]) new Object[n];
        this.n = n;
        this.count = 0;
    }

    public Stack() {
        this.items = (T[]) new Object[n];
        this.n = n;
        this.count = Integer.MAX_VALUE;
    }

    // 压栈
    public boolean push(T item) {
        if (count == n) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    // 出栈
    public T pop() {
        if (count == 0) {
            return null;
        }
        T tmp = items[count - 1];
        count--;
        return tmp;
    }

    // 获取栈顶元素
    public T peek() {
        if (count == 0) {
            return null;
        }
        return items[count - 1];
    }

    // 判断栈是否为空
    public Boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }
}
