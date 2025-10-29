package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class MaxDiameter {

    private static int maxDiameter = 0;


    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1, null, 2, 3, 4, 5});
        Map<TreeNode,Integer> map = new HashMap<>();
        maxDiameter(root,map);
        log.info("map :{} ",map);
        Optional<Integer> max = map.values().stream().max(Integer::compareTo);
        log.info("max : {}", max.orElse(0));
        log.info("Maximum diameter of tree : {}",maxDiameter(root));
    }

    public static int maxDiameter(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null){
            return -1;
        }
        int lD = maxDiameter(root.left,map) + 1;
        int rD = maxDiameter(root.right,map) + 1;
        map.put(root, lD + rD);
        return Math.max(lD, rD);
    }

    public static int maxDiameter(TreeNode root){
        height(root);
        return maxDiameter;
    }


    private static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left,right);
    }


}
