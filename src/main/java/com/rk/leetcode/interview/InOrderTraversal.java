package com.rk.leetcode.interview;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String []args){

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> nodeList = new ArrayList<>();
        inOrderTraversal(root,nodeList);
        return nodeList;

    }


    public void inOrderTraversal(TreeNode root, List<Integer> nodeList){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                nodeList.add(root.val);
                root = root.right;
            }
        }
    }




    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
