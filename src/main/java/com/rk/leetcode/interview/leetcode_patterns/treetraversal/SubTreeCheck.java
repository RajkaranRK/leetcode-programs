package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubTreeCheck {

    public static void main(String[] args) {
        TreeNode t1 = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5});
        TreeNode subtree = TreeBuilder.buildTreeV2(new Integer[]{2,4,5});
        log.info("is subtree exists in t1 tree :{}", isSubtree(t1,subtree));
        t1 = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,null,null,6});
        subtree = TreeBuilder.buildTreeV2(new Integer[]{2,4,5});
        log.info("is subtree exists in t1 tree :{}", isSubtree(t1,subtree));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(root.val != subRoot.val){
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }else{
            if(subTreeCheck(root,subRoot)){
                return true;
            }
            return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public static boolean subTreeCheck(TreeNode t1, TreeNode subtree){
        if(t1 == null && subtree == null) return true;
        if(t1 == null || subtree == null) return false;

        if(t1.val != subtree.val) return false;

        return subTreeCheck(t1.left, subtree.left) && subTreeCheck(t1.right, subtree.right);
    }
}
