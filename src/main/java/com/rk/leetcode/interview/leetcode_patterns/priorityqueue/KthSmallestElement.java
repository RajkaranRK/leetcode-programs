package com.rk.leetcode.interview.leetcode_patterns.priorityqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

@Slf4j
public class KthSmallestElement {

    public static void main(String[] args) {
        int arr[] = {3,2,1,5,6,4};
        int k = 6;
        int result = findKthSmallestElement(arr,k);
        log.info("{}th smallest element :{}", k,result);
    }

    private static int findKthSmallestElement(int arr[],int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i =0; i<k; i++){
            maxHeap.offer(arr[i]);
        }

        for(int i=k; i<arr.length; i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        return maxHeap.peek();
    }
}
