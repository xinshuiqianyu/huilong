package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/28 17:25
 * @Author: DengHuiLong
 * @Description: 二叉树的最大路径和
 */
public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子节点提供的最大贡献值
        int maxLeft = Math.max(0, dfs(root.left));
        // 右子节点提供的最大贡献值
        int maxRight = Math.max(0, dfs(root.right));
        ans = Math.max(ans, root.val + maxLeft + maxRight);
        return root.val + Math.max(maxLeft, maxRight);
    }
}
