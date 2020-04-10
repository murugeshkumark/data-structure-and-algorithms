package com.github.murugeshkumark.dsa.tree.binarySearchTree;


import com.github.murugeshkumark.dsa.common.node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeByLinkedList {

    BinaryNode root;

    public BinaryNode getRoot() {
        return root;
    }

    // Constructor
    BinarySearchTreeByLinkedList() {
        root = null;
    }

    // Insert values in BST
    void insert(int value) {
        root = insert(root, value);
    }

    // Helper Method
    BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) { // if root com.github.murugeshkumark.dsa.common.node is blank then insert new com.github.murugeshkumark.dsa.common.node there
            System.out.println("Successfully inserted " + value + " in BST");
            return createNewNode(value);
        } else if (value <= currentNode.getValue()) {
            currentNode.setLeft(insert(currentNode.getLeft(), value));
            return currentNode;
        } else {
            currentNode.setRight(insert(currentNode.getRight(), value));
            return currentNode;
        }
    }


    // creates a new blank new com.github.murugeshkumark.dsa.common.node
    public BinaryNode createNewNode(int value) {
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        return node;
    }


    // Deleting a com.github.murugeshkumark.dsa.common.node from BST
    public void deleteNodeOfBST(int value) {
        System.out.println("\n\nDeleting " + value + " from BST...");
        deleteNodeOfBST(root, value);
    }

    // Helper Method for delete
    public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.getValue()) {
            root.setLeft(deleteNodeOfBST(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(deleteNodeOfBST(root.getRight(), value));
        } else { // If currentNode is the com.github.murugeshkumark.dsa.common.node to be deleted

            if (root.getLeft() != null && root.getRight() != null) { // if nodeToBeDeleted have both children
                BinaryNode minNodeForRight = minimumElement(root.getRight());// Finding minimum element from right subtree
                root.setValue(minNodeForRight.getValue()); // Replacing current com.github.murugeshkumark.dsa.common.node with minimum com.github.murugeshkumark.dsa.common.node from right subtree
                root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue()));  // Deleting minimum com.github.murugeshkumark.dsa.common.node from right now
            } else if (root.getLeft() != null) {// if nodeToBeDeleted has only left child
                root = root.getLeft();
            } else if (root.getRight() != null) {// if nodeToBeDeleted has only right child
                root = root.getRight();
            } else // if nodeToBeDeleted do not have child (Leaf com.github.murugeshkumark.dsa.common.node)
                root = null;
        }
        return root;
    }// end of method


    // Get minimum element in binary search tree
    public static BinaryNode minimumElement(BinaryNode root) {
        if (root.getLeft() == null)
            return root;
        else {
            return minimumElement(root.getLeft());
        }
    }// end of method


    // Search a com.github.murugeshkumark.dsa.common.node in BST
    void searchForValue(int value) {
        searchForValue(root, value);
    }


    // Search a com.github.murugeshkumark.dsa.common.node in BST
    BinaryNode searchForValue(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in BST.");
            return null;
        } else if (node.getValue() == value) {
            System.out.println("Value: " + value + " found in BST.");
            return node;
        } else if (value < node.getValue()) {
            return searchForValue(node.getLeft(), value);
        } else {
            return searchForValue(node.getRight(), value);
        }
    }// end of method

    // Level order traversal of BST
    void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("\nPrinting Level order traversal of Tree...");
        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue() + " ");
            if (presentNode.getLeft() != null)
                queue.add(presentNode.getLeft());
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
    }// end of method

    // Delete entire BST
    public void deleteTree() {
        System.out.println("Deleting entire Tree...");
        root = null;
        System.out.println("Tree deleted successfully !");
    }// end of method


    void printTreeGraphically() {
        Queue<BinaryNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            if (CurrentLevel == level.peek()) { //if we are in the same level
                if (queue.peek() == null) {
                    queue.add(null);
                    level.add(CurrentLevel + 1);
                } else {
                    queue.add(queue.peek().getLeft());
                    level.add(CurrentLevel + 1);
                    assert queue.peek() != null;
                    queue.add(queue.peek().getRight());
                    level.add(CurrentLevel + 1);
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove() + "  ");
                level.remove();
            } else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if (previousLevelWasAllNull) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }//end of loop
    }//end of method

}// end of class