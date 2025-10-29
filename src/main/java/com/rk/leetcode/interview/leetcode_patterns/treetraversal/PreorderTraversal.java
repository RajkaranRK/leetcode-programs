package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author: Rajkaran
 * @use:
 **/
@Slf4j
public class PreorderTraversal {


    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        preorderTraversal(root);
        System.out.println("");

        log.info("******************");
        preorderTraversalIterative(root);
    }


    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    public static void preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                System.out.print(current.val + " ");
                stack.push(current);
                current = current.left; // Go to left child
            } else {
                current = stack.pop(); // Backtrack to the last node
                current = current.right; // Go to right child
            }
        }
        System.out.println("");
    }
}
