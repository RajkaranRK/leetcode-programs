package com.rk.leetcode.interview.dp.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GridTraveler {

    public static void main(String []args){
        GridTraveler gridTraveler = new GridTraveler();
        long count = gridTraveler.findAllPossiblePath(18,18,new HashMap<>());
        System.out.println("Total path exists "+count);

        List<List<String>> paths = pathGridTraveler(2,3);
        paths.forEach(System.out::println);


        List<String> traces = new ArrayList<>();
        pathGridTravler(2,3,"",traces);
        traces.forEach(System.out::println);
    }

    public long findAllPossiblePath(int m, int n, Map<String,Long> memo){
        String key = m+","+n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(m==1 && n==1){
            return 1;
        }
        if(m <=0 || n <= 0){
            return 0;
        }
        long count = findAllPossiblePath(m-1,n,memo) + findAllPossiblePath(m,n-1,memo);
        memo.put(key,count);
        return count;
    }


    private static void pathGridTravler(int m,int n,String path,List<String> paths){
        if(m==1 && n == 1){
            paths.add(path);
            return;
        }
        if(m < 1 || n < 1){
            return;
        }
        pathGridTravler(m-1, n, path+"D ", paths);
        pathGridTravler(m, n-1, path+"R ", paths);
    }


    private static List<List<String>> pathGridTraveler(int m, int n){
        if(m == 1 && n == 1){
            List<List<String>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        if(m < 1 || n < 1){
            return null;
        }
        List<List<String>> downPath = pathGridTraveler(m-1, n);
        if(downPath != null){
            downPath = downPath.stream().map(list -> {list.add("D"); return list;}).collect(Collectors.toList());
        }
        List<List<String>> rightPath = pathGridTraveler(m, n-1);
        if(rightPath != null){
            rightPath = rightPath.stream().map(list -> {list.add("R"); return list;}).collect(Collectors.toList());
        }
        if(downPath != null && rightPath != null){
            downPath.addAll(rightPath);
            return downPath;
        }else if(downPath == null){
            return rightPath;
        }else {
            return downPath;
        }
    }
}
