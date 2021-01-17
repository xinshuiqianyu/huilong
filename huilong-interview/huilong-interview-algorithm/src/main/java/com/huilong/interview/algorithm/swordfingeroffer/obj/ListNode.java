package com.huilong.interview.algorithm.swordfingeroffer.obj;

import lombok.Data;

/**
 * @Date: 2020/11/3 22:01
 * @Author: DengHuiLong
 * @Description:
 */
@Data
public class ListNode {

    public int val;
    public ListNode next;   // 下一个链表对象

    //赋值链表的值
    public ListNode(int x) {
        val = x;
    }
}
