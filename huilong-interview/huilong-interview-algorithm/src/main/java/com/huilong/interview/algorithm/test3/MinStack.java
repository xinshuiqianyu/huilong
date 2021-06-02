package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/5/30 17:29
 * @Author: DengHuiLong
 * @Description: 利用数组实现栈的push和pop操作，以及min函数（复杂度O(1))，得到栈的最小元素，最好线程安全的。
 */
public class MinStack {

    List<Integer> array;
    List<Integer> mArray;

    public MinStack() {
        array = new ArrayList<Integer>();
        mArray = new ArrayList<Integer>();
        mArray.add(Integer.MAX_VALUE);
    }

    public synchronized void push(int val) {
        array.add(val);
        mArray.add(Math.min(val, mArray.get(mArray.size() - 1)));
    }

    public synchronized void pop() {
        array.remove(array.size() - 1);
        mArray.remove(mArray.size() - 1);
    }

    public int top() {
        return array.get(array.size() - 1);
    }

    public int getMin() {
        return mArray.get(mArray.size() - 1);
    }
}
