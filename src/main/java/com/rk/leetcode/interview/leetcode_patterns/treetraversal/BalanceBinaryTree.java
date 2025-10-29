package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BalanceBinaryTree {

    public static void main(String[] args) {

        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        log.info("Is the tree balanced ? : {}",isBalanced(root));

    }


    public static boolean isBalanced(TreeNode root){
        return checkHeight(root) != -1;
    }


    public static int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
