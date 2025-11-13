package com.rk.leetcode.interview.leetcode_patterns.treetraversal;


import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RootToNodePath {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        List<Integer> path = new ArrayList<>();
        log.info("Is tree Path Exists : {} and path details :{}",isPathExists(root,path,5),path);
    }

    public static boolean isPathExists(TreeNode root, List<Integer> path, Integer value){
        if(root == null){
            return false;
        }
        if(root.val == value){
            path.add(root.val);
            return true;
        }
        path.add(root.val);
        boolean leftFound = isPathExists(root.left,path,value);
        boolean rightFound = isPathExists(root.right, path,value);
        if(leftFound || rightFound){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
