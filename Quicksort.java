import java.util.Random;

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
 * Filename : Quicksort.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class Quicksort {
	
	// defining a final int called INFINITY to indicate a pivot is not valid
	private static final int INFINITY = Integer.MAX_VALUE;
	
	private String pivot;
	
	// setting method for pivot
	public void setPivot(String p){
		pivot = p;
	}
	
	// getting method for pivot
	public String getPivot(){
		return pivot;
	}
	
	// default constructor for quicksort
	public Quicksort(){
		pivot = null;
	}
	
	// quicksort method taking an array and a pivot 
	public int[] quicksort(int[] A, String pivot){
		
		// saving the pivot to private field 'pivot' 
		setPivot(pivot);
		quickSort(A, 0, A.length-1);
		
		return A;
	}
	
	// quicksort method taking an array, start and end
	public void quickSort(int[] A, int p, int r){
		if(p < r){
			
			// calling select method to select the pivot based on the pivot string provided
			int q = select(A, p, r);
			
			// if q is equal to infinity, then it is a INVALID pivot point
			if(q != INFINITY){
				quickSort(A, p, q-1);
				quickSort(A, q+1, r);		
			}
		}
	}
	
	// select method to select the pivot point
	public int select(int[] A, int p , int r){
		
		// if the pivot is 'first'
		if(getPivot().equals("first")){
			
			// pick the start element to be the pivot
			int i = p;
			
			// swap the selected pivot point and the end (default pivot is end)
			swap(A, r, i);
			return Partition(A, p, r);
		}
		
		// if the pivot is 'random'
		else if(getPivot().equals("random")){
			Random randomInt = new Random();

			// getting a random number between p and r
			int i = randomInt.nextInt(r-p+1) + p;
			swap(A, r, i);
			return Partition(A, p, r);
		}
		
		// if the pivot is 'median3'
		else if(getPivot().equals("median3")){
			Random randomInt = new Random();
			
			// getting three random numbers between between r and p
			int temp1 = randomInt.nextInt(r-p+1) + p;
			int temp2 = randomInt.nextInt(r-p+1) + p;
			int temp3 = randomInt.nextInt(r-p+1) + p;

			// put them in an array
			int[] tempArray = new int[3];
			tempArray[0] = temp1;
			tempArray[1] = temp2;
			tempArray[2] = temp3;
			
			// sort the array with pivot being 'first'
			tempArray = quicksort(tempArray, "first");
			
			// picking the index at 1 because that is the median in an array with 3 elements
			int i = tempArray[1];

			swap(A, r, i);
			return Partition(A, p, r);
		}
		
		// if the pivot equals dqselect
		else if(getPivot().equals("dqselect")){
			
			// getting the size
			int size = r - p + 1;

			// dividing the size by 5
			int selection_size = size / 5;

			// creating a 2 dimensional array
			int temp[][] = new int[5][];
			
			// if the size is less than 5, cannot do deterministic quick select
			if(size < 5){

				System.out.println("The array is too small for deterministic quick select (array is smaller than 5)");
				return INFINITY;
			}
			
			// else do the deterministic quick select
			else{
				
				temp[0] = new int[selection_size];
				temp[1] = new int[selection_size];
				temp[2] = new int[selection_size];
				temp[3] = new int[selection_size];

				// temp[4] has the size of size - (selection_size*4)
				temp[4] = new int[size - (selection_size*4)];
				
				// putting the corresponding values into corresponding temp arrays
				for(int i = 0; i < selection_size; i++){
					temp[0][i] = A[i+(0*selection_size)];
					temp[1][i] = A[i+(1*selection_size)];
					temp[2][i] = A[i+(2*selection_size)];
					temp[3][i] = A[i+(3*selection_size)];
				}
				
				// special case for the last temp array
				for(int i = 0; i < size - 4*selection_size; i++){
					temp[4][i] = A[i+(4*selection_size)];
				}
				
				// sorting all 5 arrays with pivot 'first'
				temp[0] = quicksort(temp[0], "first");
				temp[1] = quicksort(temp[1], "first");
				temp[2] = quicksort(temp[2], "first");
				temp[3] = quicksort(temp[3], "first");
				temp[4] = quicksort(temp[4], "first");
			
				// getting the median of each of those 5 arrays and putting them into another array
				int[] temparray = new int[5];
				temparray[0] = getMedian(temp[0]);
				temparray[1] = getMedian(temp[1]);
				temparray[2] = getMedian(temp[2]);
				temparray[3] = getMedian(temp[3]);
				temparray[4] = getMedian(temp[4]);
				
				// sorting the new array
				temparray = quicksort(temparray, "first");
				
				// getting the median of the array and that is the pivot
				int i = getMedian(temparray);
	
				swap(A, r, i);
				return Partition(A, p, r);
			}
		}
		
		// if not inputting a valid pivot string don't do anything
		else{
			System.out.println("Invalid pivot! Please provide a valid pivot ('first', 'random', 'median3', 'dqselect')...");
			return INFINITY;
		}
	}
	
	// Partition method
	public int Partition(int[] A, int p, int r){
		
		// the pivot is the r position always (have already swapped in the previous methods)
		int pivot = A[r];
		
		// pivot position
		int i = p;
		for(int j = p; j < r; j++){
			if(A[j] <= pivot){
				swap(A, j, i);
				i++;
			}
		}
		swap(A, i, r);
	
		return i;		
	}
	
	// swap method
	public void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
	}
	
	// get median method
	public int getMedian(int[] array){

		// if array is even
		if(array.length%2 == 0){
			int index = array.length / 2;
			return array[index];
		}
		
		// if array is odd
		else{
			int index = array.length / 2;
			return array[index];
		}
	}

}
