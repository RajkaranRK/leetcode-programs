package com.rk.leetcode.test;

import com.rk.leetcode.ListNode;

public class DeleteNthNode {


    public static void main(String []args){
        DeleteNthNode deleteNthNode = new DeleteNthNode();
        ListNode head = deleteNthNode.createListNode(new int[]{1,2,3,4});
        System.out.println("Before delete");
        deleteNthNode.printList(head);
        head = deleteNthNode.deleteNthNode(head,1);
        System.out.println("After delete");
        deleteNthNode.printList(head);
    }

    private ListNode deleteNthNode(ListNode head,int n){
        ListNode temp = head;
        ListNode temp1 = head;
        int i = 0;
        while(i < n){
            temp = temp.next;
            i++;
        }
        //only one node is there so move the head to null;
        if(temp == null){
            head = head.next;
        }else{
            while(temp.next != null){
                temp = temp.next;
                temp1 = temp1.next;
            }
            temp1.next = temp1.next.next;
        }
        return head;
    }


    private ListNode createListNode(int[] arr){
        ListNode head = null;
        ListNode temp = null;
        for(int i=0; i<arr.length;i++){
            if(i == 0){
                temp = head = new ListNode(arr[i]);
            }else{
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
        }
        return head;
    }


    private void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
