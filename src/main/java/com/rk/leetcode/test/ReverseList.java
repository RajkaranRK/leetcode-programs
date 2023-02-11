package com.rk.leetcode.test;

import com.rk.leetcode.ListNode;

public class ReverseList {


    public static void main(String []args){
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.createList(new int[]{1,2,3});
        System.out.println("Before reverse");
        reverseList.printList(head);

        //now perform the reverse operation
        head = reverseList.reverse(head);
        //print list after reverse
        System.out.println("Print list after reverse");
        reverseList.printList(head);

    }


    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHeadNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }


    public void printList(ListNode head){
        ListNode temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("NULL]");
    }


    public ListNode createList(int arr[]){
        ListNode head = null;
        ListNode temp = null;
        for(int i=0;i<arr.length;i++){
            if(i == 0){
                temp = head = new ListNode(arr[i]);
            }else{
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
        }
        return head;
    }
}
