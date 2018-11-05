package de.fh_rosenheim.algorithmen.lecture05;

import java.util.ArrayList;


public class Selection {

	/**
	 * returns position of maximum inside array
	 * @param	 a		array
	 * @return			index of maximum element in array 
	 */
	public static int maximum (ArrayList<Comparable> a) {
		int maxPos = 0; 
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).compareTo(a.get(maxPos)) < 0) {
				maxPos = i;
			}
		}
		return maxPos; 
	}
	
	/**
	 * returns i.th largest element from array a[l..r]
	 * @param a		array
	 * @param i 	?-largest element 
	 * @return		i.th largest element 
	 */
	public static Comparable selectSimple(ArrayList<Comparable> a, int i) {
		int j = 1;
		while (a.size() > 0 && j < i) {
			int maxPos = maximum(a);
			a.remove(maxPos);
			j++;
		}
		return a.get(maximum(a));
	}

	/**
	 * search index of i.th largest element using Quicksort partitioning in a[l..r]
	 * @param a		input array
	 * @param i		?-largest element
	 * @param l		index of left border
	 * @param r		index of right border
	 * @return		index of i.th largst element 
	 */
	public static int selectQuicksort(Comparable a[], int l, int r, int i) {
		
		if (l == r) {	// array consists only of one element
			return l;
		}

		int p = partition(a, l, r);
		int k = p - l + 1;
		if (i == k) {
			return p;
		}
		else if (i < k) {
			return selectQuicksort(a, l, p-1, i);
		}
		else {
			return selectQuicksort(a, p+1, r, i-k);
		}
	}
	
	/**
	 * partitions Array a[l..r] into 2 parts, all elements in left part <= Pivot, all elements in right part >= Pivot
	 * @param a		input array
	 * @param l		index of left border
	 * @param r		index of right border
	 * @return		index of pivot
	 */
	public static int partition(Comparable a[], int l, int r) {

		// put Pivot to right position (goal: reuse existing algorithm)
		Comparable x = a[r];

		// Hoare: partitioning of array into 2 parts (smaller and larger than array) 
	    int i = l;
	    int j = r - 1;

	    do {
	    	// move left pointer
	        while (j > l && a[j].compareTo(x) >= 0) {
	        	j--;
	        }  
	        	
	       	// move right pointer 
	       	while (i < r && a[i].compareTo(x) <= 0) {
	       		i++;
	       	} 
	        	
	       	// exchange a[i] with a[j]
	       	if (i < j) {
	       		Comparable tmp = a[i];
	       		a[i] = a[j];
	       		a[j] = tmp;
	       	}
	    } while (i < j); 
	        	
	    if (a[i].compareTo(x) > 0) {
	      	Comparable tmp = a[i];
	       	a[i] = x;
	       	a[r] = tmp; 
	    }
	        	
	        // return index of pivot element 
	    return i; 		
	 }
	
	
	
	 public static void main(String[] args) {
		
		// Sort Integer Array (10, 20, 30, 40, 50, 60) using normal Quicksort
		Integer[] intArr = {50, 30, 20, 10, 40, 60, 70};
		System.out.println("Median von: 50, 30, 20, 10, 40, 60, 70");
		Integer median = intArr[selectQuicksort(intArr, 0, 6, 4)];
		System.out.println("Median: " + median);
	}
	
	
	
}
