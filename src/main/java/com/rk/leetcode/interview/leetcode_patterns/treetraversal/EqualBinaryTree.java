package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EqualBinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = TreeBuilder.buildTree(new int[]{1,2,3,4,5});
        TreeNode t2 = TreeBuilder.buildTree(new int[]{1,2,3,4,5});
        log.info("Are the two tree t1 and t2 are same : {} ", isSameTree(t1,t2));
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2){
        //both has leaf node
        if(t1 == null && t2 == null) return true;

        //if one having leaf not but not another
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        return isSameTree(t1.left , t2.left) && isSameTree(t1.right, t2.right);
    }
}
