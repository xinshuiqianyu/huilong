package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/28 14:32
 * @Author: DengHuiLong
 * @Description: 二叉树展开为链表
 * 1、将左子树插入到右子树的地方
 * 2、将原来的右子树接到左子树的最右边
 * 3、考虑新的右子树的跟节点，一直重复上边过程
 */
public class Flatten {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
