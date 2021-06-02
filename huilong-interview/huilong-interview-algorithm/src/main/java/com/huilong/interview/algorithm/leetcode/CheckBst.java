package com.huilong.interview.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Date: 2021/2/28 15:04
 * @Author: DengHuiLong
 * @Description: 验证二叉搜索树
 */
public class CheckBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归
    public Boolean isValidBstByRecursion(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private Boolean isValidBst(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val >= minValue || node.val <= maxValue) {
            return false;
        }
        return isValidBst(node.left, minValue, node.val) && isValidBst(node.right, node.val, maxValue);
    }

    // 中序遍历
    public Boolean isValidBstByInOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int inorder = -Integer.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
