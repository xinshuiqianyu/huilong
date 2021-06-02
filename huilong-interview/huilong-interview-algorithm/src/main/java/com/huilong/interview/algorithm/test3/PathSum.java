package com.huilong.interview.algorithm.test3;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date: 2021/4/11 0:12
 * @Author: DengHuiLong
 * @Description: 二叉树中和为某一值的路径
 */
public class PathSum {

    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();
    }
}
