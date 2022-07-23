package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(String []args){
        StringPermutation stringPermutation = new StringPermutation();
        List<String> permutations = new ArrayList<>();
        stringPermutation.findPermutation("abcdefghi",0,permutations);
        System.out.println(permutations);
        System.out.println(permutations.size());
    }

    public void findPermutation(String number, int index, List<String> permutation){
        if(number.length() == index){
            permutation.add(number);
        }else{
            for(int i=index;i<number.length();i++) {
                String str = swap(index, i, number);
                findPermutation(str, index + 1, permutation);
            }
        }
    }


    public String swap(int from, int to, String number){
        char[] arr = number.toCharArray();
        char temp = arr[from];
        arr[from] = arr[to];
        arr[to]=temp;
        return new StringBuilder().append(arr).toString();
    }
}
