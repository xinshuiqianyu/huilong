package com.huilong.interview.algorithm.test2;


/**
 * @Date: 2021/3/10 22:13
 * @Author: DengHuiLong
 * @Description: 两数相加
 */
public class AddTwoNumbers {

    // (n1 + n2 + carry) % 10
    // carry = (n1 + n2 + carry) / 10
    // 时间复杂度：O(max(m, n))
    // 空间复杂度：O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
