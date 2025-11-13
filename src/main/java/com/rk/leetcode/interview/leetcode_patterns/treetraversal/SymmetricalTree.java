package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * code to check the tree are symmetrical or not
 * i.e. mirror image or not
 */
@Slf4j
public class SymmetricalTree {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,2,3,4,4,3});
        log.info("Is tree symmetric :{} ",root == null || checkSymmetry(root.left, root.right));
    }

    public static boolean checkSymmetry(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null){
            return t1 == t2;
        }
        return t1.val == t2.val && checkSymmetry(t1.left, t2.right) && checkSymmetry(t1.right,t2.left);
    }
}
