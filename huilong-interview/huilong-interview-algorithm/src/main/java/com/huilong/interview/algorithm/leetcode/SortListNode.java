package com.huilong.interview.algorithm.leetcode;

/**
 * @Date: 2021/2/6 22:46
 * @Author: DengHuiLong
 * @Description: 排序链表，时间复杂度：O(nlogn)
 */
public class SortListNode {

    public static class ListNode {
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

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int n = 0;
        ListNode tail = head;
        while (tail != null) {
            n++;
            tail = tail.next;
        }

        tail = head;
        int[] a = new int[n];
        int i = 0;
        while (tail != null && i < n) {
            a[i++] = tail.val;
            tail = tail.next;
        }

        mergerSort(a, 0, n - 1);

        head = new ListNode(a[0]);
        tail = head;
        for (int j = 1; j < n; j++) {
            tail.next = new ListNode(a[j]);
            tail = tail.next;
        }
        return head;
    }

    public static void mergerSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergerSort(a, p, q);
        mergerSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
