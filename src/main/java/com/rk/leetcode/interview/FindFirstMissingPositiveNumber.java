package com.rk.leetcode.interview;

public class FindFirstMissingPositiveNumber {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,-3,8,2};
        int arr2[] = new int[]{9,12,4,1,2,-1,8};
        System.out.println(findMissingPositive(arr));
        System.out.println(findMissingPositive(arr2));
    }


    private static int findMissingPositive(int []arr){
        //mark the element which are out of range
        for(int i=0; i < arr.length; i++){
            if(!(arr[i] >=1 && arr[i]<=arr.length)){
                arr[i] = -1;
            }
        }

        //place the element at the correct position
        for(int i = 0; i < arr.length;){
            if(arr[i] == -1 || arr[i] == i+1){
                i++;
            }else{
                int number = arr[i];
                int number2 = arr[number-1];
                if(number2 != -1 && number != number2){
                    swap(arr,i,number-1);
                }else{
                    arr[number-1] = number;
                    i++;
                }
            }
        }
        //find which number is not at it's position
        for(int i = 0; i < arr.length; i++){
            if(arr[i]-1 !=  i){
                return i+1;
            }
        }
        return arr.length;
   }


   private static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
   }
}
