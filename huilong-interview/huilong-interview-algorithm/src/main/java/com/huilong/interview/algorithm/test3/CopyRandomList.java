package com.huilong.interview.algorithm.test3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/4/11 19:08
 * @Author: DengHuiLong
 * @Description: 复杂链表的深拷贝
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
