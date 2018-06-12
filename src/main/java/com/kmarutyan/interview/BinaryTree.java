package com.kmarutyan.interview;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
        //Root of binary search
        Node root;
        BinaryTree(){
            root = null;
        }

    /**
     * Given a binary tree, print in nodes, according to the bottom up post-order traversal
     * @param node
     */
    void printPostorder(Node node){
            if(node == null){
                return; // do nothing, base case
            }
            // first recur the left tree
            printPostorder(node.left);

            // the recur the right tree
            printPostorder(node.right);

            // Now deal with the node
            System.out.println( node.key);

     }

    /**
     * Given a binary tree, print in nodes, according to the bottom up in-order traversal
     * @param node
     */
    void printInorder(Node node){
        if(node == null){
            return; // do nothing, base case
        }
        // first recur the left tree
        printInorder(node.left);


        // Now deal with the node
        System.out.println( node.key);

        // the recur the right tree
        printInorder(node.right);


    }

    /**
     * Given a binary tree, print in nodes, according to the bottom up pre-order traversal
     * @param node
     */
    void printPreorder(Node node){
        if(node == null){
            return; // do nothing, base case
        }

        // Now deal with the node
        System.out.println( node.key);

        // first recur the left tree
        printPreorder(node.left);

        // the recur the right tree
        printPreorder(node.right);


    }

    public void bsf(Node root){
        Queue<Node> queue = new LinkedList<Node>();

        // base case
        if (root == null){
            return;
        }
        queue.clear();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.key);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }


    }

//    public void dsf (Node root){
//        Stack<Node> stack = new Stack<Node>();
//        if(root == null){
//            //base case - do nothing and return
//            return;
//        }
//       Node node = root;
//      stack.add(node);
//        while(!stack.isEmpty()){
//            stack.add(node);
//            if(node.left != null){
//                stack.add(node.left);
//            }
//            else if (node.right != null){
//                stack.add(node.right);
//            }
//        }
//    }

//}

    //  wrapper around recursive functions

    public void printPostorder(){ printPostorder(root); }
    public void printPreorder(){ printPreorder(root); }
    public void printInorder(){ printInorder(root); }
    public void printBsf(){ bsf(root); }
//    public void printDsf(){ dsf(root);




    }


class Node {
    int key;
    Node left, right;
    public Node(int item){
        key = item;
        left=right=null;
    }
}