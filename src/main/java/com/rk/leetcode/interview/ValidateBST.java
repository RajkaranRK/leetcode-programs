package com.rk.leetcode.interview;

import com.rk.leetcode.TreeNode;

public class ValidateBST {
    
    
    public static void main(String []args) {
        ValidateBST bst = new ValidateBST();
        TreeNode root = bst.populateNode();
        System.out.println(bst.isValidBST(root));
        
        root = bst.populateNode2();
        System.out.println(bst.isValidBST(root));
        
        //System.out.print(bst.getMin(root.right));
        
    }
    
    public boolean isValidBST(TreeNode root) {
        boolean isValid = isValid(root);
        isValid =  isValid && root.val > getMax(root.left) && root.val < getMin(root.right);
        return isValid;
    }
    
    
    public boolean isValid(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode node = null;
        boolean leftValid = true;
        boolean rightValid = true;
        
        if(root.left !=null){
            node = root.left;
            if(node.val >= root.val){
                return false;
            }else{
                
                leftValid = isValid(root.left);
            }
        }
        if(root.right !=null){
            node = root.right;
            if(node.val <= root.val){
                return false;
            }else{
                
                rightValid = isValid(root.right);
            }
        }
        if(!leftValid || !rightValid){
            return false;
        }
        return true;
    }
    
    
    
    public int getMin(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        int v1 = getMin(root.left);
        v1 = v1 > root.val ? root.val : v1;
        int v2 = getMin(root.right);
        v2 = v2 > root.val ? root.val : v2;
        return v1 > v2 ? v2 : v1;  
    }
    
    
    public int getMax(TreeNode root) {
        if(root==null) {
            return Integer.MIN_VALUE;
        }
        int v1 = getMax(root.left);
        v1 = root.val > v1 ? root.val : v1;
        int v2 = getMax(root.right);
        v2 = root.val > v2 ? root.val : v2;
        return v1 > v2 ? v1 : v2;
    }
    
    
    public TreeNode populateNode() {
        TreeNode root = new TreeNode(5);
        insert(root, 4, false, true);
        insert(root, 6, true, false);
        insert(root.right,3,false,true);
        insert(root.right,7,true,false);
        return root;
    }
    
    
    public void insert(TreeNode root , int val, boolean right, boolean left) {
        if(left) {
            root.left = new TreeNode(val);
        }else {
            root.right = new TreeNode(val);
        }
    }
    
    
    public TreeNode populateNode2() {
        TreeNode root = new TreeNode(32);
        insert(root, 26, false, true);
        insert(root, 47, true, false);
        insert(root.left,19, false,true);
        insert(root.right,56,true,false);
        insert(root.right.right,27,true,false);
        return root;
    } 

}
