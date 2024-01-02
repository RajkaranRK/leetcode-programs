package com.rk.leetcode;

public class Utils {

    public static ListNode populateListNode(int []arr){
        ListNode root = null;
        ListNode temp = null;
        for(int i =0; i<arr.length; i++){
            if(i == 0) {
                root = temp = new ListNode(arr[i]);
            }else {
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
        }
        return root;
    }


    public static void printListNode(ListNode root){
        ListNode temp = root;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    public static void printLineSeparator(){
        System.out.println("*******************************");
    }

    public static void printArray(int arr[]){
        if(arr == null){
            System.out.println("null");
        }
        if(arr.length == 0){
            System.out.println("[]");
        }
        System.out.print("[");
        int i =0;
        for(i =0; i<arr.length-1; i++){
            System.out.print(arr[i]+",");
        }
        System.out.print(arr[i]);
        System.out.println("]");
    }
}
