package com.kmarutyan.interview.data_structures;

public class ReverseLinkedList {
    public static void print(Node node){
        if(node != null)
            System.out.print(String.format("%d -> ",node.value));
        if(node.next!=null)
            print(node.next);
        else{
            System.out.print("null");
        }
    }
    public static Node reverse(Node node){
        if(node == null )
            return node;
        if(node.next == null)
            return null;

        Node prev = null;
        Node current = node;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev  = current;
            current = next;
        }
        node = prev;


        return node;
    }

    public static Node reverse3(Node node){
        if(node == null)
                return null;
        if(node.next == null)
                return node;

        Node prev = null;
        while(node !=null){
            Node hold = node.next;
            node.next = prev;
            prev = node;
            node =  hold;

        }

        return prev;

    }

    public static boolean hasCycle(Node slow, Node fast){
        // sanity check
        if(fast  == null || fast.next ==null)
            return false;
        if(fast.value == slow.value){
            return true;
        }

        return hasCycle(slow.next,fast.next.next) ;

    }


    public static Node reverse2(Node node, Node prev){
        if(node == null )
            return prev;

        Node next =  node.next;
        node.next = prev;
          return reverse2(next, node);

    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.setAndGetNext(2).setAndGetNext(3).setAndGetNext(4).setAndGetNext(5);
//        print(n1);
//        print(reverse(n1));
        print(reverse3(n1));

//       print(reverse2(n1, null));

//        Node nc = new Node(1);
//        nc.setAndGetNext(2).setAndGetNext(3).setAndGetNext(4).setAndGetNext(5).setNext(nc);

//        System.out.println( hasCycle(n1, n1.next));
//
//        System.out.println( hasCycle(nc, nc.next));
//

    }



}






