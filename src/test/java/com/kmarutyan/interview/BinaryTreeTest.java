package com.kmarutyan.interview;

import com.kmarutyan.interview.data_structures.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by apple on 3/19/17.
 */
public class BinaryTreeTest {


    BinaryTree tree = new BinaryTree();
    BinaryTree ubtree = new BinaryTree();


    @Before
    public void setup() {
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left.left = tree.new Node(8);
        tree.root.left.left.right = tree.new Node(9);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.left.right.right = tree.new Node(11);

        ubtree.root = ubtree.new Node(1);
        ubtree.root.left = ubtree.new Node(2);
        ubtree.root.right = ubtree.new Node(3);
        ubtree.root.left.left = ubtree.new Node(4);
        ubtree.root.left.right = ubtree.new Node(5);
        ubtree.root.right.left = ubtree.new Node(6);
        ubtree.root.right.right = ubtree.new Node(7);
        ubtree.root.left.left.left = ubtree.new Node(8);
        ubtree.root.left.left.right = ubtree.new Node(9);
        ubtree.root.left.right.left = ubtree.new Node(10);
        ubtree.root.left.right.right = ubtree.new Node(11);
        ubtree.root.left.right.right.right = ubtree.new Node(12);


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

    @Test
    public void isBalanced()  {
        assertTrue(tree.isSuperbalanced());
        assertFalse(ubtree.isSuperbalanced());

    }
}