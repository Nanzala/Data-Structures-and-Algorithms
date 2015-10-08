package org.meltwater.java.datastructures;

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
		// Position is less than size
		// 1. move every element at position and greater by 1.
		// 2. insert an element at position.
	}
	
	public static void main(String[] args) {
		
	}

}
