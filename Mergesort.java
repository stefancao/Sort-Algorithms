/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: assignment3
 * Filename : Mergesort.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */  

public class Mergesort {
	
	// set a static final int called INIFITY indicating not used
	private static final int INFINITY = Integer.MAX_VALUE;

	// default constructor
	public Mergesort(){
	
	}
	
	// method calling for mergesort passing in array
	public int[] mergesort(int[] A) {
		mergeSort(A, 0, A.length-1);
		return A;
	}
	
	// mergesort method passing in array, starting and end
	public void mergeSort(int[] A, int p, int r) {
	
		// if start is less than end
		if(p < r){
			
			// getting the middle index
			int q = (p + r) / 2;
			
			// left side
			mergeSort(A, p, q);
			
			// right side
			mergeSort(A, q+1, r);
			
			// merge them together
			Merge(A, p, q, r);	
		}	
	}

	// Method for merging together
	public void Merge(int[] A, int p, int q, int r){
		
		// calculating the sizes of arrays
		int n1 = q - p + 1;
		int n2 = r - q;
		
		//creating two new arrays
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		// copying the left side of array to array L
		for(int i = 0; i < n1; i++){
			L[i] = A[p+i];
		}
		
		// copying right side of array to array R
		for(int j = 0; j < n2; j++){
			R[j] = A[q+j+1];
		}
		
		// setting the last array slots to infinity - not using
		L[n1] = INFINITY;
		R[n2] = INFINITY;
		
		// for left array index
		int i = 0;
		
		// for right array index
		int j = 0;
		
		// starting from p to r
		for(int k = p; k <= r; k++){
			// if Left is smaller than Right, then put the Left element into the original array
			if(L[i] <= R[j]){
				A[k] = L[i];
				i = i + 1;
			}
			
			// else Right is smaller so put the Right element into the original array
			else{
				A[k] = R[j];
				j = j + 1;
			}
		}	
	}
}
