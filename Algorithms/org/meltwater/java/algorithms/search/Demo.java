package org.meltwater.java.algorithms.search;

public class Demo {
	
	private static final int ONE_MILLION = 15;
	
	public static void main(String[] args) {
		//Object[] demoArray = {1,2,34,5,63,3,"Class","Yetu"};
		//System.out.println(LinearSearch.search(demoArray, "Class"));
		
		int[] a = new int[ONE_MILLION];
		for (int i=0; i< ONE_MILLION; i++) a[i] = i;
		
		int[] elements = {1, 2, 3, 4, 5, 6};
		
		for(int i=0; i < elements.length; i++){
		int found = BinarySearch.search(a, elements[i]);
		System.out.println("Hello " + found);
		System.out.println();
		}
	
	}

}
