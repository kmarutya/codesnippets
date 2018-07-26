package com.kmarutyan.interview.data_structures;

import java.util.*;

public class BinaryTree {
        //Root of binary search
        public Node root;
        public BinaryTree(){
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


    public static void bsf2(Node root){
        //base case
        if(root == null)
            return ;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }


    }


    public static void printDsf(Node root){
        if(root == null)
            return;

        Stack<Node> stack =  new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                 stack.push(node.right);
            System.out.println(node)   ;
        }

    }

    //  wrappers around recursive functions

    public void printPostorder(){ printPostorder(root); }
    public void printPreorder(){ printPreorder(root); }
    public void printInorder(){ printInorder(root); }
    public void printBsf(){ bsf(root); }

    public int[] treeDepth(Node node, int depth){
        if(node == null)
            return new int[]{ depth, depth};
        else if(root.left == null && root.right == null){
            return new int[]{ depth, depth+1};
        }
        else{
            int[] depthLeft = treeDepth(node.left, depth+1);
            int [] depthRight = treeDepth(node.right, depth +1);
            int minDepth = Math.min(depthLeft[0], depthRight[0]);
            int maxDepth = Math.max(depthLeft[1], depthRight[1]);
            return new int[] {minDepth, maxDepth};

        }
    }

    public boolean isSuperbalanced(){
        int [] depths = treeDepth(root,0);
        int diff = depths[1] - depths[0];
        System.out.println(String.format("Min depth = %d, Max depth = %d", depths[0], depths[1]));
        if(diff <= 1)
            return true;
        else
            return false;
    }


   public class Node {
        int key;
        public Node left, right;
        public Node(int item){
            key = item;
            left=right=null;
        }
    }
}



