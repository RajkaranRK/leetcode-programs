package com.rk.leetcode.interview.leetcode_patterns.treetraversal;

import com.rk.leetcode.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * in this question we're finding the least common ancestor of a tree
 */
@Slf4j
public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTreeV2(new Integer[]{1,2,3,4,5,6,7});
        int to = 5;
        int from = 1;
        approach1(root,from,to);
        approach2(root,from,to);

    }


    /**
     * in this approach we basically we check for node if it's
     * both the left and right return the non-null value then return the root.val -> this means we find the value from both the end;
     * else check if any one of them is non-null then return than value.
     * @param root
     * @param from
     * @param to
     */
    public static void approach2(TreeNode root, int from , int to){
        log.info("Least common ancestor : {}",leastCommonAncestor(root,from,to));
    }

    public static Integer leastCommonAncestor(TreeNode root, int from, int to){
        if(root == null){
            return null;
        }
        if(root.val == from || root.val == to){
            return root.val;
        }
        Integer leftVal = leastCommonAncestor(root.left,from,to);
        Integer rightVal = leastCommonAncestor(root.right,from, to);
        if(leftVal != null && rightVal != null){
            return root.val;
        }
        if(leftVal != null){
            return leftVal;
        }else{
            return rightVal;
        }
    }



    /**
     * in this approach basically we find the path of individual node from the root
     * and then find the least common value of these path
     * @param root
     */
    public static void approach1(TreeNode root,int from , int to){

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        boolean valueExists = path(root,from, path1);
        int min = -1;
        if(valueExists){
            valueExists = path(root,to,path2);
            if(valueExists){
                for (int i =0; i< path1.size(); i++){
                    if(path1.get(i).equals(path2.get(i))){
                        min = path1.get(i);
                    }else{
                        break;
                    }
                }
            }
        }
        log.info("Least common ancestor of path :{} and path :{} is : {}",path1,path2,min);
    }

    public static boolean path(TreeNode root, int value, List<Integer> paths){
        if(root == null){
            return false;
        }
        if(root.val == value){
            paths.add(root.val);
            return true;
        }
        paths.add(root.val);
        boolean leftExists = path(root.left,value,paths);
        boolean rightExists = path(root.right,value,paths);
        if(leftExists || rightExists){
            return true;
        }
        paths.remove(paths.size() - 1);
        return false;
    }
}
