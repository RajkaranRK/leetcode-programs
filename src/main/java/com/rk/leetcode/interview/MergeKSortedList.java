package com.rk.leetcode.interview;

import com.rk.leetcode.ListNode;

public class MergeKSortedList {

    public static void main(String []args){
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode[] lists = mergeKSortedList.getKLists();
        ListNode mergeListNode =  mergeKSortedList.mergeKLists(lists);
        mergeKSortedList.print(mergeListNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode l1 = lists[0];
        for(int i=1; i<lists.length; i++){
            l1 = mergeList(l1,lists[i]);
        }
        return l1;
    }


    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeList(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeList(l1,l2.next);
            return l2;
        }
    }


    public void print(ListNode listNode){
        while(listNode !=null){
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
        System.out.println("NULL");
    }


    public ListNode[] getKLists(){
        ListNode l1 = populateListNode(new int[]{1,4,5});
        ListNode l2 = populateListNode(new int[]{1,3,4});
        ListNode l3 = populateListNode(new int[]{2,6});
        return new ListNode[]{l1,l2,l3};
    }

    public ListNode populateListNode(int []arr){
        ListNode temp = null;
        ListNode root = null;
        for(int i=0; i<arr.length; i++){
            if(root == null){
                root = new ListNode(arr[i]);
                temp = root;
            }else{
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
        }
        return root;
    }
}
