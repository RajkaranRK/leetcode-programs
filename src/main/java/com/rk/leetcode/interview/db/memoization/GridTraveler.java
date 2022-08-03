package com.rk.leetcode.interview.db.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public static void main(String []args){
        GridTraveler gridTraveler = new GridTraveler();
        long count = gridTraveler.findAllPossiblePath(18,18,new HashMap<>());
        System.out.print("Total path exists "+count);
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
}
