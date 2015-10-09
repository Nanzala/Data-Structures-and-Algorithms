package org.meltwater.java.datastructures;

/*******************************************************
* A Stack class that is implemented with arrays.
*  
********************************************************/

import java.util.*;

class ArrayStack {
    protected int array[];
    protected int top, size, length;

    public ArrayStack(int n) {
        size = n;
        length = 0;
        array = new int[size];
        top = -1;
    }
   
    /**
     *  This function checks if the stack is empty 
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**  
     *  This function checks if the stack is full 
     */
    public boolean isFull() {
        return top == size -1 ;        
    }
    
    /** 
     *  This function gets the size of the stack 
     */
    public int getSize() {
        return length ;
    }
    
    /**  
     *  This function checks the top element of the stack 
     */
    public int peek() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return array[top];
    }
    
    /**
     *  This function adds an element to the stack 
     */
    public void push(int i) {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            array[++top] = i;
        length++ ;
    }
    
    /**
     *  This function deletes an element from the stack 
     */
    public int pop() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        length-- ;
        return array[top--]; 
    }
    
    /**
     *  This function displays the status of the stack 
     */
    public void contain() {
        System.out.print("\nStack = ");
        if (length == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(array[i]+" ");
        System.out.println();
    } 
    
    /**
     * This is the main method.
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);        
        System.out.println("WELCOME TO THIS STACK IMPLEMENTATION\n");
        System.out.println("Enter Size of Integer Stack ");
        int n = scan.nextInt();

        ArrayStack stk = new ArrayStack(n);

        char ch;
        do{
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to push: ");
                try 
                {
                    stk.push( scan.nextInt() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }                         
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Popped Element = " + stk.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;    
            case 3 :         
                try
                {
                    System.out.println("Peek Element = " + stk.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = " + stk.isEmpty());
                break;                
            case 5 :
                System.out.println("Full status = " + stk.isFull());
                break;                 
            case 6 : 
                System.out.println("Size = " + stk.getSize());
                break;                         
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }
            /* display stack */
            stk.contain();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                 
    }
}
