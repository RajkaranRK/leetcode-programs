package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MaximumPathSum {

    private  static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1, null, 2, 3, 4, 5});
        maxPathSum(root);
        log.info("Maximum Path sum : {}",max);
    }


    public static int maxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int lMax = maxPathSum(root.left);
        int rMax = maxPathSum(root.right);
        max = Math.max(max,lMax + rMax + root.val);
        return root.val + Math.max(lMax,rMax);
    }


}
