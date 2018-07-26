package com.kmarutyan.interview.data_structures;

public class FindCommonParent {
    class Node {
        Node parent;
        Node left,right;
    }
    public static Node commonAncestor(Node n1, Node n2){
        Node parent = null;
        long d1 = depth(n1);
        long d2 = depth(n2);

        if(d2 > d1)
            n2 = goUp(n2,Math.abs(d1-d2));
        else
            n1 = goUp(n1,Math.abs(d1-d2));

        while(n1 != null && n2 !=null){
            n1 = n1.parent;
            n2 = n2.parent;
            if(n1.equals(n2)){ // assime equals method is implemented
                return n2;
            }
        }


        return null;
    }

    public static Node goUp(Node n, long d){
        while(d > 0 && n !=null){
            n = n.parent;
            d--;
        }
        return n;
    }
    public static long depth(Node n){
        long depth =0;
        while(n != null){
            n = n.parent;
            depth++;
        }
        return depth;

    }

    public static void main(String... args){

    }


}
