package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes’ values.
 * (i.e. from left to right, then right to left for the next level, and so on).
 */

@Slf4j
public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        zigZagTraverse2(root);
        System.out.println("");
        log.info("******************");
    }

    public static void zigZagTraverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> results = new ArrayList<>();
        boolean invertFlag = false;
        while(!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) nodes.add(queue.poll());
            log.info("Populated nodes {} ", nodes.stream().map(node->node.val).toList());
            if (invertFlag && nodes.size() > 0) {
                //start from end and first insert the right then
                int i = nodes.size() - 1;
                while(i >=0){
                    results.add(nodes.get(i).val);
                    TreeNode node = nodes.get(nodes.size() - 1 - i);
                    if(node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                    i--;
                }
            }else{
                for (int i=0; i< nodes.size(); i++){
                    TreeNode node = nodes.get(i);
                    results.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
            }
            invertFlag = !invertFlag;
        }
        log.info("Traversal Result : {}",results);
    }


    public static void zigZagTraverse2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> results = new ArrayList<>();
        boolean invertFlag = false;
        while(!queue.isEmpty()) {
            Stack<Integer> stack = new Stack<>();
            log.info("Queue :{}",queue.stream().map(node -> node.val).toList());
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i =0; i<size; i++){
                TreeNode node = queue.poll();
                if(invertFlag){
                    stack.push(node.val);
                }else{
                    level.add(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            while (!stack.isEmpty()){
                level.add(stack.pop());
            }
            results.addAll(level);
            invertFlag = !invertFlag;
        }
        log.info("Traversal Result : {}",results);
    }
}
