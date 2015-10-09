package org.meltwater.java.datastructures;

/*******************************************************
* An dynamic Array class that is generic.
*  
********************************************************/

import java.util.Scanner;

public class BetterArray {

	public static final int DEFAULT_SIZE = 10;
	private int[] array;
	private int size;
	
	public BetterArray() {
		array = new int[DEFAULT_SIZE];
		size = 0;
	}
	
	public void add(int[] elements) {
		for (int i : elements)
			add(i);
	}
	
	public void add(int element) {
		
		if (size == array.length ){
			//Double array, then insert
			int[] newArray = new int[array.length*2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
		this.array[size++] = element;
	}
	
	
	public void add(int position, int element) throws Exception {
		// size is the number of elements
		if (position > size)
			throw new Exception ();
		
		if (position == size) {
			add(element);
			return;
		}
	}
	
	/**
	 * This function returns the array size
	 */
	public int getSize() {         
		return size;
	}
	
	 /**
	  * This function gets the value at a certain index
	  */
	public int getValue(int index) {

		if(index < size) return array[index];
			return 0;
	}
	
	/** 
	 * This function returns true or false if a value is in the array
	 */
	public boolean contains(int searchValue){      
		boolean valueInArray = false;
 
	    for(int i = 0; i < size; i++) {
	       
	    	if(array[i] == searchValue) {
              
	          valueInArray = true;
            
            }
        }
        
	    return valueInArray;
	         
    }
	
	// Delete Array row for the index and move elements up*/
	     
    public void deleteIndex(int index) {
        
    	if(index < size) {
             
           for(int i = index; i < (size - 1); i++) {
             array[i] = array[i+1];
	       }
           
           size--;   
        }    
    }
	
	
	
	public static void main(String[] args) {
		
		int n, position, x;
		
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter no. of elements you want in the array: ");
        n = s.nextInt();
        int a[] = new int[n+1];
        System.out.println("Enter all the elements: ");
        for(int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.print("Enter the position where you want to insert element: ");
        position = s.nextInt();
        System.out.print("Enter the element you want to insert: ");
        x = s.nextInt();
        for(int i = (n-1); i >= (position-1); i--) {
            a[i+1] = a[i];
        }
        a[position-1] = x;
        System.out.print("After inserting: ");
        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i]+",");
        }
        System.out.print(a[n]);
	}

}
