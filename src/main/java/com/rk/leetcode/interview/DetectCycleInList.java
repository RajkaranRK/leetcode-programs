package com.rk.leetcode.interview;

import com.rk.leetcode.ListNode;

public class DetectCycleInList {
    
    public static void main(String []args) {
        ListNode root = populateList();
        detectAndRemoveCycle(root);
        printList(root);
    }
    
    
    private static ListNode populateList() {
        ListNode root = new ListNode(1);
        ListNode temp = root;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next= new ListNode(3);
        temp = temp.next;
        temp.next = root;
        return root;
    }
    
    private static void detectAndRemoveCycle(ListNode root) {
        //first traverse in linked list and whichever node is tranversed maked as visited
        ListNode current = root;
        ListNode prev = root;
        while(current != null) {
            if(!current.isVisited) {
                prev = current;
                prev.isVisited = true;
                current = current.next;
            }else {
                prev.next = null;
                break;
            }
        }
    }
    
    
    private static void printList(ListNode root) {
        ListNode temp = root;
        while(temp != null) {
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}
