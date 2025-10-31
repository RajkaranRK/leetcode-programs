package com.rk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private final Map<K,Node<K,V>> map;

    private final DoublyLinkedList<K,V> ddl;

    private final Integer capicity;

    public LRUCache(Integer capicity){
        this.map = new HashMap<>();
        this.ddl = new DoublyLinkedList<>();
        this.capicity = capicity;
    }


    public V get(K key){
        //check is it in map if then return else null
        Node<K,V> node = map.getOrDefault(key,null);
        if(node == null){
            return null;
        }
        //move to front
        ddl.moveToFront(node);
        return node.value;
    }


    public void put(K key, V value){
        if(map.containsKey(key)){
            ddl.moveToFront(map.get(key)); //key exists then move to front
        }else{
            if(map.size() > capicity){
                Node<K,V> node = ddl.removeLast();
                map.remove(node.key);
            }
            Node<K,V> node = new Node<>(key,value);
            ddl.addFirst(node); //add to first
            map.put(key,node);
        }
    }



    private static class Node<K,V> {

        K key;
        V value;
        Node<K,V> prev,next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

    }

    public static class DoublyLinkedList<K,V>{

        private Node<K, V> head, tail;

        public void addFirst(Node<K,V> node){
            if(head == null){
                head = tail = node;
            }else{
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public Node<K,V> removeLast(){
            if(tail == null) return null;
            Node<K,V> node = tail;
            if(tail.prev != null){
                tail = tail.prev;
                tail.next = null;
            }else{
                tail = head = null;
            }
            return node;
        }

        public void moveToFront(Node<K,V> node){
            if(node == head){
                return;
            }
            if(node.prev != null) node.prev.next = node.next;
            if(node.next != null) node.next.prev = node.prev;
            if(node == tail) tail = node.prev;

            head.prev = node;
            node.next = head;
            node.prev = null;
            head = node;
        }

    }


}

