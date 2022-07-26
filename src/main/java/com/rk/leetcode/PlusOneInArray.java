package com.rk.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlusOneInArray {


    public static void main(String []args){
        PlusOneInArray plusOneInArray = new PlusOneInArray();
        int []arr = plusOneInArray.plusOne(new int[]{9});
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }


    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length ==0){
            return digits;
        }
        int end = digits.length-1;
        int sum = digits[end] + 1;
        int carry = sum / 10;
        digits[end] = sum;
        end--;
        while(end>=0  && carry == 1){
            sum =  carry + digits[end];
            digits[end] = sum % 10;
            carry = sum / 10;
            end--;
        }
        if(carry == 1){
            int newArr[] = new int[digits.length+1];
            newArr[0] = carry;
            for(int i=0;i< digits.length;i++){
                newArr[i+1] = digits[i];
            }
            return newArr;
        }
        return digits;
    }
}
