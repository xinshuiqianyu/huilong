package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/14 21:43
 * @Author: DengHuiLong
 * @Description:
 */
public class SlowAndFast {
    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode mid = findMid(head);
        System.out.println(mid);
    }
}
