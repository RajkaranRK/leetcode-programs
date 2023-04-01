package com.rk.leetcode.interview.linkedlist;

import com.rk.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate {


  public static void main(String[] args) {
    //remove duplicate elements
    ListNode root = populateDuplicateData(new int[]{1, 3, 2, 1, 2, 4});
    LinkedListUtils.printList(root);

    removeDuplicate(root);
    LinkedListUtils.printList(root);

    root = populateDuplicateData(new int[]{1, 2});
    LinkedListUtils.printList(root);

    removeDuplicate(root);
    LinkedListUtils.printList(root);
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
