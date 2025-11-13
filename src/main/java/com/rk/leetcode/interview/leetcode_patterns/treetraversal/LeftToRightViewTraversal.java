package com.rk.leetcode.interview.leetcode_patterns.treetraversal;


import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class LeftToRightViewTraversal {


    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        log.info("Top view traversal :{} ",leftToRightView(root));
    }

    public static List<Integer> leftToRightView(TreeNode root){
        Queue<LeftToRightTreeNode> queue = new LinkedList<>();
        Map<Integer,TreeNode> leftToRightMap = new TreeMap<>();
        queue.offer(new LeftToRightTreeNode(root,0));
        while (!queue.isEmpty()){
            LeftToRightTreeNode node = queue.poll();
            if(!leftToRightMap.containsKey(node.level)){
                leftToRightMap.put(node.level,node.node);
            }
            if(node.node.left != null) queue.offer(new LeftToRightTreeNode(node.node.left,node.level+1));
            if(node.node.right != null) queue.offer(new LeftToRightTreeNode(node.node.right,node.level+1));
        }
        return leftToRightMap.entrySet().stream().map(entry -> entry.getValue().val).toList();
    }


}

class LeftToRightTreeNode {
    Integer level;
    TreeNode node;

    public LeftToRightTreeNode(TreeNode node,Integer level){
        this.node = node;
        this.level = level;
    }
}