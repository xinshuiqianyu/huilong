package com.huilong.interview.algorithm.geek.stack;

/**
 * @Date: 2020/11/22 19:30
 * @Author: DengHuiLong
 * @Description: 基于链表实现的栈
 */
public class LinkedListStack {

    private Node top = null;

    // 入栈
    public void push(int value) {
        Node node = new Node(value, null);
        // 判断是否栈空
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    // 出栈，-1表示栈中没有数据
    public int pop() {
        if (top == null) {
            return -1;
        }
        int value = top.getData();
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 链表结点
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
