package com.huilong.interview.algorithm.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date: 2021/3/28 10:13
 * @Author: DengHuiLong
 * @Description: 二叉树的层序遍历
 */
public class LevelOrder {

    // 二叉树的层序遍历，BSF
    // 利用队列实现 BSF
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                tmp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            ans.add(tmp);
        }

        return ans;
    }
}
