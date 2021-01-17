package com.huilong.interview.algorithm.geek.linkedlist;


import lombok.Data;

import java.util.Scanner;

/**
 * @Date: 2020/11/17 22:14
 * @Author: DengHuiLong
 * @Description: 基于单链表 LRU 算法
 */
public class LRUByLinkedList<T> {

    /**
     * 链表默认容量
     */
    private final static Integer DEFAULT_CAPACITY = 3;
    /**
     * 头结点
     */
    private Node<T> headNode;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUByLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUByLinkedList(Integer capacity) {
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    @Data
    public static class Node<T> {

        private T data;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(T data) {
        // 判断要插入的数据是否存在，如果存在，删除存在元素，将该元素插入头部
        // 如果不存在，判断是否超出容量，如果超出容量，删除最后一个元素，将该元素插入头部
        Node preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表头部
        if (preNode != null) {
            deleteNode(preNode);
            insertBegin(data);
        } else {
            if (length >= capacity) {
                // 删除尾结点
                deleteEnd();
            }
            insertBegin(data);
        }
    }

    /**
     * 获取查找元素的前一个结点
     *
     * @param data data
     * @return Node
     */
    private Node findPreNode(T data) {
        Node node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode preNode
     */
    private void deleteNode(Node preNode) {
        Node deleteNode = preNode.getNext();
        preNode.setNext(deleteNode.getNext());
        deleteNode = null;
        length--;
    }

    /**
     * 链表头部插入结点
     *
     * @param data data
     */
    private void insertBegin(T data) {
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }

    /**
     * 删除尾结点
     */
    private void deleteEnd() {
        Node ptr = headNode;
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        Node deleteNode = ptr.getNext();
        ptr.setNext(null);
        deleteNode = null;
        length--;
    }

    private void printAll() {
        Node node = headNode.getNext();
        while (node != null) {
            if (node.getNext() != null) {
                System.out.print(node.getData() + ",");
            } else {
                System.out.print(node.getData());
            }
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUByLinkedList list = new LRUByLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
