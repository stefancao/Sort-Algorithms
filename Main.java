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
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class Main {

	public static void main(String[] args) {
		int[] newArray = new int[15];
		newArray[0] = 2;
		newArray[1] = 4;
		newArray[2] = 11;
		newArray[3] = 6;
		newArray[4] = 8;
		newArray[5] = 20;
		newArray[6] = 3;
		newArray[7] = 7;
		newArray[8] = 0;
		newArray[9] = 10;
		newArray[10] = 1;
		newArray[11] = 40;
		newArray[12] = 2;
		newArray[13] = 14;
		newArray[14] = 9;
		

		// testing quicksort
		System.out.println("***Testing QuickSort***");
		Quicksort newQuicksort = new Quicksort();
		
		// creating a new 'a' which is a a copy of newArray and 
		int[] a = new int[newArray.length];
		for(int i = 0; i < newArray.length; i++){
			a[i] = newArray[i];
		}

		// creating another array
		int [] a_sorted = new int[15];
		
		// quicksort pivot as 'first'
		System.out.println("Testing Quicksort pivot as 'first'");
		System.out.println("Here is 'a' array before being sorted: ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("Here is a_sorted after calling 'a_sorted = newQuicksort.quicksort(a, \"first\");' ");
		a_sorted = newQuicksort.quicksort(a, "first");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a_sorted[i]);
		}
		
		// putting array 'a' as the orignal unsorted back 
		for(int i = 0; i < newArray.length; i++){
			a[i] = newArray[i];
		}
		
		// quicksort pivot as 'random'
		System.out.println("\n\nTesting Quicksort pivot as 'random'");
		System.out.println("Here is 'a' array before being sorted: ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("Here is a_sorted after calling 'a_sorted = newQuicksort.quicksort(a, \"random\");' ");
		a_sorted = newQuicksort.quicksort(a, "random");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a_sorted[i]);
		}
		
		// putting array 'a' as the orignal unsorted back 
		for(int i = 0; i < newArray.length; i++){
			a[i] = newArray[i];
		}
		
		// quicksort pivot as 'median3'
		System.out.println("\n\nTesting Quicksort pivot as 'median3'");
		System.out.println("Here is 'a' array before being sorted: ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("Here is a_sorted after calling 'a_sorted = newQuicksort.quicksort(a, \"median3\");' ");
		a_sorted = newQuicksort.quicksort(a, "median3");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a_sorted[i]);
		}
		
		// putting array 'a' as the orignal unsorted back 
		for(int i = 0; i < newArray.length; i++){
			a[i] = newArray[i];
		}
		
		// quicksort pivot as 'dqselect'
		System.out.println("\n\nTesting Quicksort pivot as 'dqselect'");
		System.out.println("Here is 'a' array before being sorted: ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("Here is a_sorted after calling 'a_sorted = newQuicksort.quicksort(a, \"dqselect\");' ");
		a_sorted = newQuicksort.quicksort(a, "dqselect");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a_sorted[i]);
		}


		
		// testing mergesort
		// putting array 'a' as the orignal unsorted back 
		for(int i = 0; i < newArray.length; i++){
			a[i] = newArray[i];
		}
		
		System.out.println("\n\n\n***Testing MergeSort***");
		
		System.out.println("Here is 'a' array before being sorted: ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a[i]);
		}
		
		
		Mergesort newMergesort = new Mergesort();
		a_sorted = newMergesort.mergesort(a);
		System.out.println("Here is a_sorted after calling 'a_sorted = newMergesort.mergesort(a);' ");
		for(int i = 0; i < a_sorted.length; i++){
			System.out.println(a_sorted[i]);
		}

	}

}
