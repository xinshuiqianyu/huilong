package com.huilong.interview.algorithm.swordfingeroffer.obj;

import lombok.Data;

/**
 * @Date: 2020/11/3 22:51
 * @Author: DengHuiLong
 * @Description:
 */
@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
