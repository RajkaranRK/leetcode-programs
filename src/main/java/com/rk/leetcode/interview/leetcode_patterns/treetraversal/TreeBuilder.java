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


    public static TreeNode buildTreeV2(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
