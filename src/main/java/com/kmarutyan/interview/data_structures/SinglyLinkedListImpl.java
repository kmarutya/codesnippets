package com.kmarutyan.interview.data_structures;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by apple on 7/23/18.
 */
public class SinglyLinkedListImpl<T>{
    private Node<T> head;

    public void add(T element){
        Node<T> node = new Node<>(element);
        if(head == null) {
            head = node;
        }
        else{
            Node tmp = head;
            while(true){
                Node next = tmp.getNextRef();
                if(next == null){
                    tmp.setNextRef(node);
                    break;
                }
                else{
                    tmp = tmp.getNextRef();
                }
            }
        }
    }

    public void traverse(){
       Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.print(tmp.getValue()+"\t");
            tmp = tmp.getNextRef();
        }
    }

    // 1 2 3 4
    public void reverse(){
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null){
            System.out.println(cur.getValue() + " ->"+ prev.getValue());
            next = cur.getNextRef(); // 3 , 4
            cur.setNextRef(prev); // 2->1, 3->2
            prev = cur; // prev = 2, 3
            cur = next; // cur 3, 4


          //  System.out.println(prev.getValue());

        }
        head = prev;
    }


    public static void main(String [] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(5,4,3,2,1));

       // list.stream().forEach(l-> System.out.println(l));
      // System.out.println("\n\nPrint reversed list");
      //  reverseList(list).forEach(l-> System.out.println(l));

        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);

       sl.traverse();
        System.out.println();
       sl.reverse();
        System.out.println("Print reversed linked list");
      // sl.traverse();


    }



    class Node<T> implements Comparable<T> {

        public Node(){}
        public Node(T elem){ this.setValue(elem);}
        private T value;
        private Node<T> nextRef;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node<T> ref) {
            this.nextRef = ref;
        }

        @Override
        public int compareTo(T arg) {
            if (arg == this.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }

}
