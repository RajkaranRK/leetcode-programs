package com.rk.leetcode.interview.leetcode_patterns.binarysearch;

public class SearchInRotatedArray {

    public static void main(String []args){
        SearchInRotatedArray rotatedArray = new SearchInRotatedArray();

        int index = rotatedArray.search(new int[]{1,3},2);
        System.out.println("index "+index);
        index = rotatedArray.search2(new int[]{4,5,6,7,8,0,1,2},0);
        System.out.println(index);
    }


    public int search2(int[]nums, int target){
        if(nums==null || nums.length==0) return -1;
        int l=0, r=nums.length-1, m=0;
        // find out the index of the smallest element.
        while(l<r){
            m = (l+r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }

        // since we now know the start, find out if the target is to left or right of start in the array.
        int s = l;
        l = 0; r = nums.length-1;
        if(target >= nums[s] && target <= nums[r]){
            l = s;
        }else{
            r = s;
        }
        // the regular search.
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target) return m;
            else if(nums[m] > target) r = m-1;
            else l=m+1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int i =0;
        int j = nums.length-1;
        int index = -1;
        while(i<=j){
            if(nums[i]== target){
                index = i;
                break;
            }
            if(nums[j] == target){
                index = j;
                break;
            }
            i++;j--;
        }
        return index;
    }


}
