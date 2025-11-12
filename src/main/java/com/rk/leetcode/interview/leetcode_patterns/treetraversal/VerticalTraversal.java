package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import com.sun.source.tree.Tree;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 */
@Slf4j
public class VerticalTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        List<List<Integer>> result = verticalTraversal(root);
        log.info("Result of traversal :{}",result);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root){
        Map<Integer,Map<Integer, List<Integer>>> verticalMap = new TreeMap<>();
        Queue<VerticalTreeNode> queue = new LinkedList<>();
        queue.offer(new VerticalTreeNode(root,0,0));
        while (!queue.isEmpty()){
            VerticalTreeNode node = queue.poll();
            if(verticalMap.containsKey(node.vertical)){
                Map<Integer,List<Integer>> data = verticalMap.get(node.vertical);
                if(data.containsKey(node.level)){
                    data.get(node.level).add(node.node.val);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(node.node.val);
                    data.put(node.level,list);
                }
            }else{
                Map<Integer,List<Integer>> map = new TreeMap<>();
                List<Integer> list = new ArrayList<>();
                list.add(node.node.val);
                map.put(node.level,list);
                verticalMap.put(node.vertical,map);
            }
            if(node.node.left != null) queue.offer(new VerticalTreeNode(node.node.left,node.vertical - 1,node.level + 1));
            if (node.node.right != null) queue.offer(new VerticalTreeNode(node.node.right, node.vertical + 1, node.level + 1));
        }
        List<List<Integer>> results = new ArrayList<>();
        verticalMap.entrySet().forEach(entry -> {
            results.add(entry.getValue().entrySet().stream().flatMap(e -> e.getValue().stream()).collect(Collectors.toList()));
        });
        return results;
    }
}


class VerticalTreeNode {

    TreeNode node;
    Integer vertical;
    Integer level;

    public VerticalTreeNode(TreeNode node, Integer vertical, Integer level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}