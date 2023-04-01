package com.rk.leetcode.sorting;

import com.rk.leetcode.ListNode;
import com.rk.leetcode.interview.linkedlist.LinkedListUtils;

public class MergeList {

  public static void main(String[] args) {
    ListNode l1 = createList(new int[]{1,2,5});
    LinkedListUtils.printList(l1);
    ListNode l2 = createList(new int[]{2,3,4});
    LinkedListUtils.printList(l2);
    l1 = mergeList(l1,l2);
    LinkedListUtils.printList(l1);
  }


  private static ListNode mergeList(ListNode l1, ListNode l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    if(l1.val > l2.val){
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }
    ListNode root = l1;
    ListNode p1 = null;
    while (l1 != null && l2 != null) {
      if(l1.val <= l2.val){
        p1 = l1;
        l1 = l1.next;
      }else{
        p1.next = l2;
        l2 = l2.next;
        p1 = p1.next;
      }
    }
    if(l1 != null){
      p1.next = l1;
    }else if(l2 != null){
      p1.next = l2;
    }
    return root;
  }


  private static ListNode createList(int arr[]){
    ListNode root = null;
    ListNode temp = null;
    for(int i =0; i<arr.length; i++){
      if(root == null){
        root = new ListNode(arr[i]);
        temp = root;
      }else {
        temp.next = new ListNode(arr[i]);
        temp = temp.next;
      }
    }
    return root;
  }

}
