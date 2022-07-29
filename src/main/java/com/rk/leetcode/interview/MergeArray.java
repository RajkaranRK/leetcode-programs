package com.rk.leetcode.interview;

public class MergeArray {
    
    public static void main(String []args) {
        MergeArray mergeArray = new MergeArray();
        mergeArray.merge(new int[] {1,2,3},3, new int[] {2,4,5}, 3);
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []k = new int[m+n];
        int len = 0;
        int i =0;
        int j =0;
        while(i<m || j<n){
            if(i<m && j<n){
                int val1 = nums1[i];
                int val2 = nums2[j];
                if(val1 < val2){
                    k[len++] = val1;
                    i++;
                }else{
                    k[len++] = val2;
                    j++;
                }
            }
            if(i>=m){
                k[len++] = nums2[j++]; 
            }else{
                k[len++] = nums1[i++];
            }
        }
        
        
        for(int o=0; o<k.length;o++) {
            System.out.print(k[o]+",");
        }
    }
}
