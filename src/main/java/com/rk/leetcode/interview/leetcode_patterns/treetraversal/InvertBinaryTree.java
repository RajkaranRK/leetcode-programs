package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvertBinaryTree {


    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        LevelOrderTraversal.levelOrderTraversal(root);
        TreeNode invertedTree = invertTree(root);
        System.out.println("");
        LevelOrderTraversal.levelOrderTraversal(invertedTree);
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
