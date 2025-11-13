package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        LevelOrderTraversal.levelOrderTraversal(root);
        TreeNode mirrorTree = invertTree(root);
        System.out.println("");
        LevelOrderTraversal.levelOrderTraversal(mirrorTree);
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
