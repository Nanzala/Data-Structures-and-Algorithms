package org.meltwater.java.datastructures;

/*******************************************************
* A Queue class that is implemented with arrays.
*  
********************************************************/

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
	
	/** 
	 * This function checks whether the queue has elements or is empty.
	 */
	public boolean isEmpty() {
	    return front == -1;
	} 
	
	/**
	 *  This function checks whether the queue is full.
	 */
	public boolean isFull() {
       return front==0 && back == size -1;
    }  
	
	/**
	 *  This function gets the size of the queue.
	 */
    public int getSize() {
        return length;
    } 
    
    /**
     * This function checks the first element of the queue.
     */
    public int peek() {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        return queue[front];
    }
    
    /** 
     * This function inserts an element to the queue.
     */
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
    
    /** 
     * This function removes the front element from the queue 
     */
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
    
    /** 
     * This function displays the status of the queue 
     */
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
    
    /**
     * This is the main method.
     */
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("WELCOME TO THIS QUEUE IMPLEMENTATION \n");
        System.out.println("Enter Size of Integer Queue: ");
        int n = scan.nextInt();
        
        ArrayQueue q = new ArrayQueue(n);        
               
        char ch;
        do{
            System.out.println("\nQueue Operations");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert: ");
                try
                {
                    q.enqueue( scan.nextInt() );
                }
                catch(Exception e)
                {
                    System.out.println("Error : " +e.getMessage());
                }                         
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Removed Element = "+q.dequeue());
                }
                catch(Exception e)
                {
                    System.out.println("Error : " +e.getMessage());
                }
                break; 
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+q.peek());
                }
                catch(Exception e)
                {
                    System.out.println("Error : "+e.getMessage());
                }
                break;                            
            case 4 : 
                System.out.println("Empty status = "+q.isEmpty());
                break;                
            case 5 : 
                System.out.println("Full status = "+q.isFull());
                break;                          
            case 6 : 
                System.out.println("Size = "+ q.getSize());
                break;                         
            default : System.out.println("Wrong Entry \n ");
                break;
            }
            /* display Queue */
            q.contain();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                                                        
    }    
}
