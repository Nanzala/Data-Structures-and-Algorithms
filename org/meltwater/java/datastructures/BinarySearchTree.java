package org.meltwater.java.datastructures;

/*******************************************************
* A Binary Search Tree class.
*  
********************************************************/

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;             

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  
        private int N;             
    }
    
    /**
     * Initializes an empty Binary Search Tree.
     */
    public BinarySearchTree() {
    }
    
    /**
     * Returns true if this Binary Search Tree is empty.
     * @return true if this Binary Search Tree is empty; or false if otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

     /**
     * Returns the total number of nodes in the tree.
     * @return the total number of nodes in the tree.
     */
    public int size() {
        return size(root);
    }

    /** 
     * Returns the number of key-value pairs in Binary Search Tree rooted at x
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
    
    /**
     * Searches Binary Search Tree if it contains a certain key.
     *
     * @param  key
     * @return true if this Binary Search Tree contains key and false if otherwise.
     * @throws NullPointerException if key is not there
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key
     * @return the value associated with the given key if the key is in the Binary Search Tree
     *         and null if the key is not in the Binary Search Tree
     * @throws NullPointerException if key is not there
     */
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) 
        	return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) 
        	return get(x.left, key);
        else if (cmp > 0) 
        	return get(x.right, key);
    
    else              
	   return x.val;
    }
    
    /**
     * Returns the smallest key in the Binary Search Tree.
     *
     * @return the smallest key in the Binary Search Tree
     * @throws NoSuchElementException if the Binary Search Tree is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called minimum key with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) 
        	return x; 
        else                
        	return min(x.left); 
    }
    
    /**
     * Removes the smallest key and its value from the Binary Search Tree.
     *
     * @throws NoSuchElementException if the Binary Search Tree is empty
     */
    public void removeMin() {
        if (isEmpty()) throw new NoSuchElementException("Binary Search Tree is empty");
        root = removeMin(root);
    }

    private Node removeMin(Node x) {
        if (x.left == null) return x.right;
        x.left = removeMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
        
    /**
     * Removes the key and associated value from the Binary Search Tree
     *
     * @param  key
     * @throws NullPointerException if key is not there
     */
    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node x, Key key) {
        if (x == null) 
        	return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = remove(x.left,  key);
        else if (cmp > 0) x.right = remove(x.right, key);
        else { 
            if (x.right == null) 
            	return x.left;
            if (x.left  == null) 
            	return x.right;
            Node t = x;
            x = min(t.right);
            x.right = removeMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    } 
    
    /**
     * Returns the node that has the smallest value.
     *
     * @return the node that has the smallest value.
     * @throws NoSuchElementException if the Binary Search Tree is empty
     */
    public Key smallest() {
        if (isEmpty()) throw new NoSuchElementException("called smallest node with empty Binary Search Tree");
        return smallest(root).key;
    } 

    private Node smallest(Node x) { 
        if (x.left == null) 
        	return x; 
        else               
        	return smallest(x.left); 
    } 

    /**
     * Returns the node that has the largest value.
     *
     * @return the node that has the largest value.
     * @throws NoSuchElementException if the Binary Search Tree is empty
     */
    public Key largest() {
        if (isEmpty()) throw new NoSuchElementException("called largest node with empty Binary Search Tree");
        return largest(root).key;
    } 

    private Node largest(Node x) {
        if (x.right == null) 
        	return x; 
        else
        	return largest(x.right); 
    } 
    
    /**
     * Main method to test the code.
     */
    public static void main(String[] args) { 
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        
    }
}