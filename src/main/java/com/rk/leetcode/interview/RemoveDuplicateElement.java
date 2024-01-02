package com.rk.leetcode.interview;

import com.rk.leetcode.Utils;

public class RemoveDuplicateElement {

    public static void main(String[] args) {
        int []arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        Utils.printArray(arr);
        Utils.printLineSeparator();
        int count = removeDuplicate(arr);
        System.out.println("non duplicate element found "+count);
        Utils.printArray(arr);
    }

    private static int removeDuplicate(int arr[]){
        if(arr.length == 1){
            return 1;
        }
        int prev = arr[0];
        int prevIndex = 1;
        int count = 1;
        for(int i =1; i<arr.length; i++){
            if(prev != arr[i]){
                count++;
                prev = arr[i];
                arr[prevIndex++] = arr[i];
            }
        }
        while (prevIndex < arr.length) {
            arr[prevIndex++] = 0;
        }
        return count;
    }


}
