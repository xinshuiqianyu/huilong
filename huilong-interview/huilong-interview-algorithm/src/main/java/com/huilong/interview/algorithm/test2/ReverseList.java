package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/14 11:02
 * @Author: DengHuiLong
 * @Description: 链表反转
 * next = cur.next; cur.next = pre; pre = cur; cur = next
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
