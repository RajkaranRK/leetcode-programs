package com.rk.leetcode.interview.linkedlist;

import com.rk.leetcode.ListNode;

public class LinkedListUtils {

  public static void printList(ListNode root) {
    ListNode temp = root;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
    System.out.println("NULL");
  }


}
