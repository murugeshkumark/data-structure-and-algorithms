package com.github.murugeshkumark.ds.tree.binarytree;

import com.github.murugeshkumark.node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeByLinkedList {
    BinaryNode root;


    //Constructor for creating a blank Binary Tree
    BinaryTreeByLinkedList() {
        this.root = null;
    }


    // inserts a new com.github.murugeshkumark.dsa.common.node at deepest place in Tree
    void insert(int value) {
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        if (root == null) {
            root = node;
            System.out.println("Successfully inserted new com.github.murugeshkumark.dsa.common.node at Root !");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new com.github.murugeshkumark.dsa.common.node !");
                break;
            } else if (presentNode.getRight() == null) {
                presentNode.setRight(node);
                System.out.println("Successfully inserted new com.github.murugeshkumark.dsa.common.node !");
                break;
            } else {
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }//end of else-if
        }//end of loop
    }//end of method


    // Search for a given value in binary tree
    void search(int value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.getValue() == value) {
                System.out.println("Value-" + value + " is found in Tree !");
                return;
            } else {
                if (presentNode.getLeft() != null)
                    queue.add(presentNode.getLeft());
                if (presentNode.getRight() != null)
                    queue.add(presentNode.getRight());
            }
        }//end of loop
        System.out.println("Value-" + value + " is not found in Tree !");
    }//end of method


    // delete com.github.murugeshkumark.dsa.common.node from binary tree
    void deleteNodeOfBinaryTree(int value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            // if com.github.murugeshkumark.dsa.common.node is found then copy deepest com.github.murugeshkumark.dsa.common.node here and delete deepest com.github.murugeshkumark.dsa.common.node.
            if (presentNode.getValue() == value) {
                presentNode.setValue(getDeepestNode().getValue());
                DeleteDeepestNode();
                System.out.println("Deleted the com.github.murugeshkumark.dsa.common.node !!");
                return;
            } else {
                if (presentNode.getLeft() != null)
                    queue.add(presentNode.getLeft());
                if (presentNode.getRight() != null)
                    queue.add(presentNode.getRight());
            }
        }//end of while loop
        System.out.println("Did not find the com.github.murugeshkumark.dsa.common.node!!");
    }


    //Delete deepest com.github.murugeshkumark.dsa.common.node
    public void DeleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.getLeft() == null) {
                assert previousNode != null;
                previousNode.setRight(null);
                return;
            } else if ((presentNode.getRight() == null)) {
                presentNode.setLeft(null);
                return;
            }
            queue.add(presentNode.getLeft());
            queue.add(presentNode.getRight());
        }//end of while loop
    }//end of method


    // get last com.github.murugeshkumark.dsa.common.node of last level of binary tree
    public BinaryNode getDeepestNode() {
        // make an empty com.github.murugeshkumark.dsa.queue. Queue is Interface and LinkedList is class
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.getLeft() != null)
                queue.add(presentNode.getLeft());
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
        return presentNode;
    }//end of method


    // pre-order traversal of binary tree
    void preOrder(BinaryNode node) {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }//end of method


    // post-order traversal of binary tree
    void postOrder(BinaryNode node) {
        if (node == null)
            return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }//end of method


    // in-order traversal of binary tree
    void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }//end of method


    // level order traversal of binary tree
    void levelOrder() {
        // make a com.github.murugeshkumark.dsa.queue for level order. Queue is Interface and LinkedList is class
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");
            if (presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
    }// end of method


    // Delete Tree
    void deleteTree() {
        root = null;
        System.out.println("Binary Tree has been deleted successfully");
    }

}//end of class
