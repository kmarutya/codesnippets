package com.kmarutyan.interview.data_structures;

import java.util.*;

public class Node implements Comparable<Integer>{

    public Node(Integer elem){
        this.value = elem;
    }
    public Integer value;
    public Node next;

    public Node setAndGetNext(int val) {
        this.next = new Node(val);
        return this.next;
    }

    @Override
    public int compareTo(Integer arg) {
        return  arg.compareTo(value);
    }

    public String toString(){
        StringBuilder sb =  new StringBuilder();
        Node n = this;
        while(n!= null){
            sb.append(n.value).append("->");
            n = n.next;
        }

        return sb.toString();
    }


    public static Node removeDupes(Node n){
        Set<Integer> vals = new HashSet<>();
        Node cur = n;
        vals.add(cur.value);
        while( cur.next != null){
            if( vals.contains(cur.next.value)){
                cur.next = cur.next.next;
            }
            else{
                vals.add(cur.next.value);
                cur = cur.next;
            }
        }
        return n;
    }

    public static Node removeDupesNoBuffer(Node n){
        Node cur = n;
        while(cur.next != null) {
            cur = removeDupeInTail(cur);
            cur = cur.next;
        }
       return n;
    }
    public static Node removeDupeInTail(Node n){
        Node cur = n;
        Integer val = cur.value;
        while(cur.next != null){
            if(cur.next.value == val){
                // rewire node if dupe is found
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }

        return n;
    }
    public static void removeDupes2(Node node){
        Set<Integer> set = new HashSet<>();
        Node prev = null;
        while(node != null){
            if(set.contains(node.value)){
                prev.next    = node.next;
            }
            else{
                set.add(node.value);
                prev = node;
            }
            node = node.next;
        }
    }


    public static void returnKthLast(Node n, int k){
        Node n1 = n;
        Node n2 = n;
        for(int i = 0; i < k; i++){
            n2 = n2.next;
            if(n2 == null)
                return ;
        }
        while(n2 != null){
            n2 = n2.next;
            n1 = n1.next;
        }
        System.out.println(String.format("%dth element is %d",k, n1.value));
    }

    public static int returnKthLastRecursive(Node n, int k){
        if(n == null){
            return 0;
        }

        int index = returnKthLastRecursive(n.next, k) + 1;
//        if(index == k)
            System.out.println(String.format("%dth element is %d",index, n.value));

        return index;
    }


    public static Node arrayToSLinkedList(int [] arr){
        if(arr == null || arr.length ==0 )
            return null;
        Node head = new Node(arr[0]);
        Node curNode = head;
        for(int i = 1; i < arr.length; i++){
            Node next  = new Node(arr[i]);
            curNode.next  = next;
            curNode = next;
        }
        return head;
    }
    public static void main(String [] args){
//        LinkedList<Integer> list = new LinkedList<>();
//        list.addAll(Arrays.asList(5,4,3,2,1));
        // list.stream().forEach(l-> System.out.println(l));
        // System.out.println("\n\nPrint reversed list");
        //  reverseList(list).forEach(l-> System.out.println(l));

        int [] arr = new int[]{34,4,3,1,5,5,6,95,5,3,33,93};
        System.out.println(arrayToSLinkedList(arr));
        System.out.println(removeDupes(arrayToSLinkedList(arr)));
        System.out.println(removeDupesNoBuffer(arrayToSLinkedList(arr)));


    //            Node n2 = genNode();
    //            removeDupes2(n2);
    //            System.out.println(n2);
    //
    //            returnKthLast(genNode(), 3);
    //            returnKthLastRecursive(genNode(),3);


    }


}


