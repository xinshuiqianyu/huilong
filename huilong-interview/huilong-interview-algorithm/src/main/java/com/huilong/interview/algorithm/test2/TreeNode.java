package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/28 10:13
 * @Author: DengHuiLong
 * @Description: 搜索二叉树
 */
public class TreeNode {
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
