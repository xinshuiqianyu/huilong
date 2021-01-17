package com.huilong.interview.algorithm.swordfingeroffer;

import com.huilong.interview.algorithm.swordfingeroffer.obj.ListNode;

import java.util.ArrayList;

/**
 * @Date: 2020/11/3 22:07
 * @Author: DengHuiLong
 * @Description: * @Description: https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * <p>
 * 输入
 * {67,0,24,58}
 * 返回值
 * [58,24,0,67]
 */
public class PrintListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);

        ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
        System.out.println(arrayList);
    }
}
