package org.meltwater.java.algorithms.search;

public class BinarySearch {
	private BinarySearch() {}
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public static int search(int[] array, int e) {
		int first = 0;
		int last = array.length - 1;
		int mid, midElement;
		
		while (first <= last) {
		//System.out.println (tries +	
		
			mid = (first + last) / 2;
			midElement = array[mid];
			
			if(midElement == e) {
				return mid;
			}
			else if(midElement > e) {
				last = mid - 1; 
			}
			 if(midElement > e) {
				last = mid + 1;
			 }
		}    
			
		return ELEMENT_NOT_FOUND;
	}
	
	private static int searchRecursion(int [] a, int e, int f, int l) {
		if (f>l) return ELEMENT_NOT_FOUND;
		
		int mid = (f+l)/2;
		int midElement = a[mid];
		
		if (midElement == e) {
			return mid;
		}
		else if (midElement > e) {
			return searchRecursion (a,e,f, mid-1);
		}
		else {
			return searchRecursion (a, e, mid + 1, l);
		}
	}
	
	public static int searchRecursion(int[] array, int e) {
		return searchRecursion(array, e, 0, array.length - 1); 
	}

}
