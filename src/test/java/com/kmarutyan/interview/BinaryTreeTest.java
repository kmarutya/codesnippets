package com.kmarutyan.interview;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by apple on 3/19/17.
 */
public class BinaryTreeTest {


    com.kmarutyan.interview.BinaryTree tree = new com.kmarutyan.interview.BinaryTree();

    @Before
    public void setup() {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);

    }

    /*
                        1
                    2       3
                4    5     6  7
               8-9  10-11

     */

    @org.junit.Test
    public void printPostorder() throws Exception {
        tree.printPostorder();
    }

    @org.junit.Test
    public void printPreorder() throws Exception {
        tree.printPreorder();
    }

    @org.junit.Test
    public void printInorder() throws Exception {
        tree.printInorder();
    }

    @Test
    public void bsf() throws Exception {
        tree.printBsf();
    }
}