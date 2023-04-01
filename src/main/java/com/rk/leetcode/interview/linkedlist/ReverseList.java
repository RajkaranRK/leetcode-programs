package com.rk.leetcode.interview.linkedlist;

import com.rk.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;

public class ReverseList {


  public static void main(String[] args) {

    ListNode root = populateList();
    printList(root);
    root = reverseList(root);
    printList(root);

    //remove duplicate elements
    root = populateDuplicateData(new int[]{1, 3, 2, 1, 2, 4});
    printList(root);

    removeDuplicate(root);
    printList(root);

    root = populateDuplicateData(new int[]{1, 2});
    printList(root);

    removeDuplicate(root);
    printList(root);

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


  public static void printList(ListNode root) {
    ListNode temp = root;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
    System.out.println("NULL");
  }


  private static ListNode populateDuplicateData(int[] arr) {
    ListNode root = null;
    ListNode temp = null;
    for (int i = 0; i < arr.length; i++) {
      if (root == null) {
        root = new ListNode(arr[i]);
        temp = root;
      } else {
        temp.next = new ListNode(arr[i]);
        temp = temp.next;
      }
    }
    return root;
  }


  private static void removeDuplicate(ListNode root) {
    ListNode current = root;
    ListNode prev = null;
    Map<Integer, Integer> map = new HashMap<>();
    while (current != null) {
      if (map.containsKey(current.val)) {
        prev.next = current.next;
        current = current.next;
      } else {
        map.put(current.val, 1);
        prev = current;
        current = current.next;
      }
    }
  }

}
