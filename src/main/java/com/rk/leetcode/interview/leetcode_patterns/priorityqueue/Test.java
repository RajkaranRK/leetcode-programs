package com.rk.leetcode.interview.leetcode_patterns.priorityqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Test {


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Raj","Raj");
        map.put("Karan","Karan");
        map.put("Rajkaran","Rajkaran");
        map.put("Pintu","pintu");
        sortMap(map);
    }


    private static void sortMap(Map<String,String> map){
        Map<String,String> sortedMap = new TreeMap<>(map);
        log.info("Un-sorted map : {}",map);
        log.info("Sorted Map : {}",sortedMap);
        sortedMap = map.entrySet().stream()
                        .sorted((e1,e2)->e1.getKey().compareTo(e2.getKey()))
                        .collect(
                            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new)
                        );
        log.info("Sorted Map : {}",sortedMap);
    }


    private static int kthSmallestElement(int []arr, int k){
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((e1,e2) -> e2.compareTo(e1));
        int i = 0;
        while (i < arr.length){
            maxPriorityQueue.offer(arr[i]);
            if(maxPriorityQueue.size() > k){
                int poll = maxPriorityQueue.poll();
                log.info("Poll data : {}", poll);
            }
            i++;
        }
        return maxPriorityQueue.peek() == null ? - 1: maxPriorityQueue.peek();
    }

    private static int kthLargestElement(int []arr, int k){
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        int i = 0;
        while (i < arr.length){
            minPriorityQueue.offer(arr[i]);
            if(minPriorityQueue.size() > k){
                int poll = minPriorityQueue.poll();
                log.info("Poll data {}",poll);
            }
            i++;
        }
        return minPriorityQueue.peek() == null ? -1 : minPriorityQueue.peek();
    }
}
