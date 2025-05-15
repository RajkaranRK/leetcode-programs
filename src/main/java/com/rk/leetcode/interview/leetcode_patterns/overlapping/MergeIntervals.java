package com.rk.leetcode.interview.leetcode_patterns.overlapping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class MergeIntervals {

    public static void main(String[] args) {
        List<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[]{1,3});
        intervals.add(new Integer[]{2,4});
        intervals.add(new Integer[]{2,6});
        intervals.add(new Integer[]{8,10});
        intervals.add(new Integer[]{8,11});
        intervals.add(new Integer[]{15,18});
        //intervals.add(new Integer[]{16,17});
        intervals.add(new Integer[]{21,23});
        List<Integer[]> results = mergeInterval(intervals);
        log.info("Merged Intervals...");
        results.forEach(arr -> log.info("[{},{}]",arr[0],arr[1]));
    }


    private static List<Integer[]> mergeInterval(List<Integer[]> intervals){
        List<Integer[]> results = new ArrayList<>();
        results.add(intervals.get(0));
        //[1,3],[2,6],[8,10],[15,18]
        for (int i = 1; i < intervals.size(); i++){
            Integer[] current = intervals.get(i);
            Integer[] interval = results.get(results.size()-1);
            if(current[0] >= interval[0] && current[0] <= interval[1]){
                if(current[1] > interval[1]){
                    interval[1] = current[1];
                }
            }else{
                results.add(current);
            }
        }
        return results;
    }
}
