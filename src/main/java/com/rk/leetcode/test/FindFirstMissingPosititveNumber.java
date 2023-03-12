package com.rk.leetcode.test;

public class FindFirstMissingPosititveNumber {
    
    public static void main(String []args) {
        int number = findFirstMissingPositive(new int[] {2,3,5,9,0,-1,-2,7});
        System.out.println(number);
    }
    
    
    private static int findFirstMissingPositive(int arr[]) {
        boolean isOneFound = false;
        for(int i=0;i<arr.length; i++) {
            if(arr[i] == 1) {
                isOneFound= true;
            }
            if(arr[i] < 1 || arr[i] > arr.length) {
                arr[i] = 1;
            }
        }
        if(!isOneFound) {
            return 1; 
        }
        printArray(arr);
        for(int i =0; i<arr.length; i++) {
            int index = Math.abs(arr[i]);
            arr[index-1] = -Math.abs(arr[index-1]);
        }
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0) {
                return i+1;
            }
        }
        return arr.length+1;
    }
    
    private static void printArray(int []arr) {
        for(int i =0 ;i<arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }

}
