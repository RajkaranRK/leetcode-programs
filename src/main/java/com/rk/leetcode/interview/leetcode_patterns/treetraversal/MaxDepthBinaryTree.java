package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxDepthBinaryTree {



    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        log.info("Max depth of tree :{} ",maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lDepth = maxDepth(root.left) + 1;
        int rDepth = maxDepth(root.right) + 1;
        return Math.max(lDepth,rDepth);
    }
}
