package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7});
        levelOrderTraversal(root);
        System.out.println("");
        log.info("******************");
    }


    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.val+",");
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }
}
