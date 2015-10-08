package org.meltwater.java.algorithms.search;

public class LinearSearch {
	
	private LinearSearch() {
		
	}
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/*
	 * Integer returned is the index of "element" in "array"
	 * For example if you search for the number 20 and it's not in the array,
	 * the program returns -1.
	 */
	public static int search(int[] array, int element) {
		
		/* 
		 * int index = -1;
		 * for (int i = 0; i < array.length; i++)
	           if (array[i] == element) {
	                 index = i;
	                 break;  
	      	}
			return index;
		 */
		
		/* Searches from back to front
		 * int index = -1
		 * for (  int i > -1; i = array.length - 1; i--)
	           if (array[i] == element) {
	                 index = i;
	                 break;  
	      	}
			return index;
		 */
		
		for (int index = 0; index < array.length; index++)
	      {
	           if (array[index] == element) {
	                 return index;  
	           }
	      }
		return -1;
	}
	
	public static int search(Object[] array, Object e) {
		
		for(int i = 0; i < array.length; i++)
			if (array[i].equals(e)) {
				return i;
			}
		return ELEMENT_NOT_FOUND;
	}
}