package com.rk.leetcode.interview.tree;

import java.util.Stack;

import com.rk.leetcode.TreeNode;

public class PostorderTraversal {
    

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        postorderTraversal(root);
        posrorderTraversalUsingDoubleStack(root);
        postorderTraversalUsing2XValueInsert(root);
        postorderTraversalUsingLastPopVariable(root);
    }

    private static void postorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    private static void posrorderTraversalUsingDoubleStack(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode current = s1.pop();
            result.push(current);
            if(current.left != null){
                s1.push(current.left);
            }
            if(current.right != null){
                s1.push(current.right);
            }
        }
        System.out.println("");
        while (!result.isEmpty()) {
            System.out.print(result.peek().val + " ");
            result.pop();
        }
        System.out.println("");
    }


    private static void postorderTraversalUsing2XValueInsert(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                if(!stack.isEmpty() && current.equals(stack.peek())){
                    current = current.right;
                }else{
                    System.out.print(current.val + " ");
                    current = null;
                }
            }
        }
        System.out.println("");
    }


    private static void postorderTraversalUsingLastPopVariable(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastPop = null;
        while(!stack.isEmpty() || current !=null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.peek();
                if(lastPop == null || current.right == null || lastPop.equals(current.right)){
                    lastPop = stack.pop();
                    System.out.print(current.val+" ");
                    current = null;
                }else{
                    current = current.right;
                }
            }
        }
        System.out.println("");
    }
}
