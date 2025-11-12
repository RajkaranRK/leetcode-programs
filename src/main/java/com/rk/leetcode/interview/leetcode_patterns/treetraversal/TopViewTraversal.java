package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TopViewTraversal {


    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        log.info("Top view traversal :{} ",topView(root));
    }

    public static List<Integer> topView(TreeNode root){
        Queue<TopViewTreeNode> queue = new LinkedList<>();
        Map<Integer,TreeNode> verticalMap = new TreeMap<>();
        queue.offer(new TopViewTreeNode(root,0));
        while (!queue.isEmpty()){
            TopViewTreeNode node = queue.poll();
            if(!verticalMap.containsKey(node.vertical)){
                verticalMap.put(node.vertical, node.node);
            }
            if(node.node.left != null ) queue.offer(new TopViewTreeNode(node.node.left,node.vertical-1));
            if(node.node.right != null) queue.offer(new TopViewTreeNode(node.node.right,node.vertical + 1));
        }
        return verticalMap.entrySet().stream().map(node -> node.getValue().val)
                .collect(Collectors.toList());
    }
}

class TopViewTreeNode {
    Integer vertical;
    TreeNode node;

    public TopViewTreeNode(TreeNode node, Integer vertical){
        this.vertical = vertical;
        this.node = node;
    }
}
