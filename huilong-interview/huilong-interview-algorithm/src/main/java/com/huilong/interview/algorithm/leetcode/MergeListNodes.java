package com.huilong.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date: 2021/2/4 22:58
 * @Author: DengHuiLong
 * @Description:
 */
public class MergeListNodes {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeListNodesByDivideAndConquer(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aHead = a;
        ListNode bHead = b;
        while (aHead != null && bHead != null) {
            if (aHead.val < bHead.val) {
                tail.next = aHead;
                aHead = aHead.next;
            } else {
                tail.next = bHead;
                bHead = bHead.next;
            }
            tail = tail.next;
        }
        tail.next = (aHead != null ? aHead : bHead);
        return head.next;
    }

    public ListNode mergeListNodesByForce(ListNode[] lists) {
        List<Integer> mergeArray = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                mergeArray.add(listNode.val);
                listNode = listNode.next;
            }
        }
        if (mergeArray.size() == 0) {
            return null;
        }
        Collections.sort(mergeArray);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (Integer i : mergeArray) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return head.next;
    }

    public ListNode mergeListNodesByOrder(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
}
