package com.rk.leetcode.interview;

import com.rk.leetcode.ListNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MergeLinkedList {

    public static void main(String []args){

        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        ListNode list1 = mergeLinkedList.populateList(new int[]{1,2,3});
        System.out.println("list1 ");
        mergeLinkedList.printList(list1);
        ListNode list2 = mergeLinkedList.populateList(new int[]{1,4,5});
        System.out.println("list2 ");
        mergeLinkedList.printList(list2);

        ListNode mergeList = mergeLinkedList.mergeTwoLists(list1,list2);

        System.out.println("mergeList ");
        mergeLinkedList.printList(mergeList);


    }


    public void printList(ListNode root){
        while (root != null){
            System.out.print(root.val);
            root = root.next;
        }
        System.out.println("NULL");
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }


    }



    public ListNode populateList(int []arr){
        ListNode root = null;
        ListNode temp = root;
        for(int i=0; i<arr.length;i++){
            if(root == null){
                root = new ListNode(arr[i],null);
                temp = root;
            }else{
                temp.next = new ListNode(arr[i],null);
                temp = temp.next;
            }
        }
        return root;
    }

}
