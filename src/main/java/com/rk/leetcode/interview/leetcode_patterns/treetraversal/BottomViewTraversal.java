package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BottomViewTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        log.info("Top view traversal :{} ",bottomView(root));
    }

    public static List<Integer> bottomView(TreeNode root){
        Queue<BottomViewTreeNode> queue = new LinkedList<>();
        queue.offer(new BottomViewTreeNode(root,0));
        Map<Integer,TreeNode> bottomViewMap = new TreeMap<>();
        while(!queue.isEmpty()){
            //poll queue
            BottomViewTreeNode node = queue.poll();
            bottomViewMap.put(node.vertical, node.node);
            if(node.node.left != null) queue.offer(new BottomViewTreeNode(node.node.left, node.vertical - 1));
            if(node.node.right != null) queue.offer(new BottomViewTreeNode(node.node.right, node.vertical+1));
        }
        return bottomViewMap.entrySet().stream().map(entry -> entry.getValue().val).toList();
    }
}


class BottomViewTreeNode {

    Integer vertical;

    TreeNode node;

    public BottomViewTreeNode(TreeNode node, Integer vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
