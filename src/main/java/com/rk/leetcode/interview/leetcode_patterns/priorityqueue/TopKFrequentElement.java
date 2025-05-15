package com.rk.leetcode.interview.leetcode_patterns.priorityqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TopKFrequentElement {


    public static void main(String[] args) {
        int arr[] = {1,2,2,4,4,3,3,3};
        int k = 2;
        log.info("most frequent {} elements:{}",k,topKFrequentElement(arr,k));
        test(new int[]{5,20,10},3);
        test(new int[]{10,20,5},3);
    }

    private static List<Integer> topKFrequentElement(int []arr, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        //populating the frequency
        for (int i=0; i<arr.length; i++){
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i],0)+1);
        }
        //Create a priority Queue
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((a,b)->b.compareTo(a));

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k){
                Map.Entry<Integer,Integer> pollEntry = priorityQueue.poll();
                log.info("Removed :{}",pollEntry);
            }
        }
        return priorityQueue.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }


    private static void test(int arr[],int n){
        new PriorityQueue<>(3);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0;i<arr.length; i++){
            priorityQueue.offer(arr[i]);
        }
        Optional<Integer> optional = priorityQueue.stream().limit(n)
                .skip(n-1)
                .findFirst();
       log.info("{}th largest element :{}",n,optional.get());
    }
}
