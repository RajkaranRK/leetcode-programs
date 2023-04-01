package com.rk.leetcode.interview.linkedlist;

import com.rk.leetcode.ListNode;

public class ReverseList {


  public static void main(String[] args) {

    ListNode root = populateList();
    LinkedListUtils.printList(root);
    root = reverseList(root);
    LinkedListUtils.printList(root);

  }


  private static ListNode reverseList(ListNode root) {
    ListNode prev = null;
    ListNode temp = null;
    ListNode current = root;
    while (current != null) {
      temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev;
  }


  private static ListNode populateList() {
    ListNode root = null;
    ListNode temp = null;
    for (int i = 1; i <= 5; i++) {
      if (root == null) {
        root = new ListNode(i);
        temp = root;
      } else {
        temp.next = new ListNode(i);
        temp = temp.next;
      }
    }
    return root;
  }

}
