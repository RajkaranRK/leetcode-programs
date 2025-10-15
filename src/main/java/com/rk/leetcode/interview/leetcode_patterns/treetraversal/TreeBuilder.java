package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Rajkaran
 * @use:
 **/
public class TreeBuilder {

    public static TreeNode buildTree(int arr[]){
        TreeNode root = new TreeNode(arr[0]); // created root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < arr.length){
            TreeNode node = queue.poll();
            if( i < arr.length){
                TreeNode leftChild = new TreeNode(arr[i++]);
                node.left = leftChild;
                queue.offer(leftChild);
            }
            if(i<arr.length){
                TreeNode rightChild = new TreeNode(arr[i++]);
                node.right = rightChild;
                queue.offer(rightChild);
            }
        }
        return root;
    }
}
