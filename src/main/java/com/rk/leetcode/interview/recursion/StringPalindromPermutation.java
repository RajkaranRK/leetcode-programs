package com.rk.leetcode.interview.recursion;

import java.util.HashSet;
import java.util.Set;

public class StringPalindromPermutation {

    public static void main(String []args){
        StringPalindromPermutation stringPermutation = new StringPalindromPermutation();
        Set<String> permutations = new HashSet<>();
        stringPermutation.findPermutation("acbccbac",0,permutations);
        System.out.println(permutations);
        System.out.println(permutations.size());
    }

    public void findPermutation(String number, int index, Set<String> permutation){
        if(number.length() == index){
            if(isPalindrom(number)) {
                permutation.add(number);
            }
            return;
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


    public static boolean isPalindrom(String s){
        int i =0,j=s.length() - 1;
        char[] arr = s.toCharArray();
        boolean isPalindrom = true;
        while(i<j){
            if(arr[i++] != arr[j--]){
                isPalindrom = false;
                break;
            }
        }
        return isPalindrom;
    }
}
