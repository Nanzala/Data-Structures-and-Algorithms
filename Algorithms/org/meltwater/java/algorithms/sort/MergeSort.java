package org.meltwater.java.algorithms.sort;

public class MergeSort {

	private MergeSort() {}

	public static int[] mergeSort(int[] array) {

		if (array.length == 1) 
			return array;
	
		int arrayLength = array.length / 2;
	
		int[] leftArray = new int [arrayLength];
		int[] rightArray = new int [arrayLength];
	
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
	
		return merge(leftArray, rightArray);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] sortedArray = new int [left.length + right.length];
		
		while (sortedArray.length > 0) {
			if (left.length > right.length) {
				
			}
		}
		
	}
}
