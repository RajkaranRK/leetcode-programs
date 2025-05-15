package com.rk.leetcode.interview.leetcode_patterns.priorityqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

@Slf4j
public class KthLargestElement {


    public static void main(String[] args) {
        int arr[] = {3,2,1,5,6,4};

        int result = findKthLargest(arr,3);
        log.info("{}th largest element :{}", 3,result);
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->a.compareTo(b));
        for(int i =0; i<k; i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll(); //remove the element
                minHeap.offer(nums[i]); //then add the element to heap
            }
        }
        return minHeap.peek();
    }
}
