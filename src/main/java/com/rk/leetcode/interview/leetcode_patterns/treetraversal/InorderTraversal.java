package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author: Rajkaran
 * @use:
 **/
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        inorderTraversal(root);
        System.out.println("");
        System.out.println("******************");
        inorderTraversalIterative(root);
    }


    private static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }


    private static void inorderTraversalIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.val +" ");
                current = current.right;
            }
        }
    }
}
