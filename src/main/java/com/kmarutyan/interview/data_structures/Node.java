package com.kmarutyan.interview.data_structures;

import java.util.*;

public class Node implements Comparable<Integer>{

    public Node(Integer elem){ this.value = elem;}
    public Integer value;
    public Node next;

    public Node setAndGetNext(int val) {  this.next = new Node(val); return this.next; }


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


    public static void removeDupes(Node node){
        Node checked = node;
        Node candidate = checked.next;

        Set<Integer> set = new HashSet<>();
        while(candidate!=null){
            if( !set.contains(candidate.value)){
                checked.next = candidate;
                checked = candidate;
                candidate = candidate.next;
                set.add(checked.value);

                checked.next= null;

            }
            else{
                candidate = candidate.next;
            }
        }
        System.out.println(node);
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

    public static Node genNode(){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next.next.next = new Node(7);
        return node;

    }

        public static void main(String [] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(5,4,3,2,1));

        // list.stream().forEach(l-> System.out.println(l));
        // System.out.println("\n\nPrint reversed list");
        //  reverseList(list).forEach(l-> System.out.println(l));


            System.out.println(genNode());

            removeDupes(genNode());
            Node n2 = genNode();
            removeDupes2(n2);
            System.out.println(n2);

            returnKthLast(genNode(), 3);
            returnKthLastRecursive(genNode(),3);


        }


}


