package org.meltwater.java.datastructures;

import java.util.*;

public class ArrayQueue {
	protected int queue[];
    protected int front, // first index of the queue
    			  back, // last index of the queue
    			  size, // size of queue
    			  length; // current length of queue
		
	public ArrayQueue(int n) {
		size = n;
        length = 0;
        queue = new int[size];
        front = -1;
        back = -1;
	}
	
	/* This function checks whether the queue has elements or is empty */
	public boolean isEmpty() {
	    return front == -1;
	} 
	
	/* This function checks whether the queue is full */
	public boolean isFull() {
       return front==0 && back == size -1;
    }  
	
	/* This function gets the size of the queue */
    public int getSize() {
        return length;
    } 
    
    /* This function checks the first element of the queue */
    public int peek() {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        return queue[front];
    }
    
    /*  This function inserts an element to the queue */
    public void enqueue(int i) {
        if (back == -1) {
            front = 0;
            back = 0;
            queue[back] = i;
        }
        else if (back + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        else if ( back + 1 < size)
            queue[++back] = i;    
        length++ ;    
    }  
    
    /*  This function removes the front element from the queue */
    public int dequeue() {
        if (isEmpty()) {
           throw new NoSuchElementException("Underflow Exception");
        } 
        else {
            length-- ;
            int element = queue[front];
            if ( front == back) 
            {
                front = -1;
                back = -1;
            }
            else
                front++;                
            return element;
        }        
    }
    
    /*  This function displays the status of the queue */
    public void contain() {
        System.out.print("\nQueue = ");
        if (length == 0) {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= back; i++)
            System.out.print(queue[i]+" ");
        System.out.println();        
    }	
}
