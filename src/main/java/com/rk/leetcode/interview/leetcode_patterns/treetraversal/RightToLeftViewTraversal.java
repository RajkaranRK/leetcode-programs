package com.rk.leetcode.interview.leetcode_patterns.treetraversal;


import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class RightToLeftViewTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        log.info("Top view traversal :{} ",rightToLeftView(root));
    }

    public static List<Integer> rightToLeftView(TreeNode root){
        Queue<RightToLeftTreeNode> queue = new LinkedList<>();
        Map<Integer,TreeNode> rightToLeftMap = new TreeMap<>();
        queue.offer(new RightToLeftTreeNode(root,0));
        while(!queue.isEmpty()){
            RightToLeftTreeNode node = queue.poll();
            rightToLeftMap.put(node.level,node.node);
            if(node.node.left != null) queue.offer(new RightToLeftTreeNode(node.node.left,node.level+1));
            if(node.node.right != null) queue.offer(new RightToLeftTreeNode(node.node.right, node.level+1));
        }
        return rightToLeftMap.entrySet().stream().map(entry -> entry.getValue().val).toList();
    }
}


class RightToLeftTreeNode {
    Integer level;
    TreeNode node;
    public RightToLeftTreeNode(TreeNode node, Integer level){
        this.node = node;
        this.level = level;
    }
}