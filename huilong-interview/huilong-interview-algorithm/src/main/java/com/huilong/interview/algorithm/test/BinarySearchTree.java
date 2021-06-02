package com.huilong.interview.algorithm.test;

/**
 * @Date: 2021/2/25 21:44
 * @Author: DengHuiLong
 * @Description: 二叉查找树
 */
public class BinarySearchTree {

    private Node tree;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void delete(int data) {
        // p 指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp 记录的是 p 的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到要删除的节点
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树的最小节点
            Node minP = p.right;
            // minPP 表示 minP 的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将 minP 的数据替换到 p 中
            p.data = minP.data;
            // 下面就变成删除 minP
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有哟个子节点
        Node child; // p 的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 删除的是根节点
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }
}
