package com.rk.leetcode.test;

import com.rk.leetcode.ListNode;

import java.util.*;

public class AddTwoNumbers {

    public static void main(String []args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.find3Sum(new int[]{1,2,3,4,5,6,7,8,9,0,1});
    }



    public void find3Sum(int []arr){
        for(int i=0; i < arr.length; i++){
            
        }
    }


    public int[] findTwo(int arr[], int first, int target, int start, int end){
        Set<Integer> numSet = new HashSet<>();
        for(int i=start; i < end; i++ ){
            int sum = target - arr[i];
            if(numSet.contains(sum)){
                return new int[]{first,sum, arr[i]};
            }else{
                numSet.add(arr[i]);
            }
        }
        return null;
    }




    public ListNode addTwoNumber(ListNode l1, ListNode l2,int carry){
        if(l1 == null && l2 == null){
            if(carry != 0){
                return new ListNode(carry);
            }
            return null;
        }
        int v1 = 0;
        int v2 = 0;
        if(l1 != null){
            v1 = l1.val;
        }
        if(l2 != null){
            v2 = l2.val;
        }
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        sum = sum % 10;
        if(l1 != null && l2 != null){
            l1.val = sum;
            l1.next = addTwoNumber(l1.next,l2.next,carry);
            return l1;
        }else{
            if(l1 == null){
                l2.val = sum;
                if(carry != 0){
                    l2.next = addTwoNumber(l1,l2.next,carry);
                }
                return l2;
            }else{
                l1.val = sum;
                if(carry != 0){
                    l1.next = addTwoNumber(l1.next,l2,carry);
                }
                return l1;
            }
        }
    }
}
