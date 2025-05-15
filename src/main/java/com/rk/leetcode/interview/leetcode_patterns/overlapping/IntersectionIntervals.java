package com.rk.leetcode.interview.leetcode_patterns.overlapping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class IntersectionIntervals {


    public static void main(String[] args) {
        List<Integer[]> firstList = new ArrayList<>();
        firstList.add(new Integer[]{0,2});
        firstList.add(new Integer[]{5,10});
        firstList.add(new Integer[]{13,23});
        firstList.add(new Integer[]{24,25});
        List<Integer[]> secondList = new ArrayList<>();
        secondList.add(new Integer[]{1,5});
        secondList.add(new Integer[]{8,12});
        secondList.add(new Integer[]{15,24});
        secondList.add(new Integer[]{25,26});
        List<Integer[]> result =  intersection(firstList,secondList);
        result.forEach(arr -> log.info("[{},{}]",arr[0],arr[1]));
    }

    private static List<Integer[]> intersection(List<Integer[]> firstList, List<Integer[]> secondList){
       // firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
        List<Integer[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.size() && j < secondList.size()){
            int start = Math.max(firstList.get(i)[0],secondList.get(j)[0]);
            int end = Math.min(firstList.get(i)[1], secondList.get(j)[1]);
            if(start <= end){
                result.add(new Integer[]{start,end});
            }
            if(firstList.get(i)[1] < secondList.get(j)[1]){
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
}
