package p01;

import java.util.List;

public class TestDriver {
	
	
	public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        List<List<Integer>> allPermutations = PermutationGenerator.generatePermutations(arr);
		// MergeSort
		
		// HeapSort
        for (List<Integer> perm : allPermutations) {
    		HeapSort ob = new HeapSort();
        	//fills an int array with the Integer List
        	int[] intArray = new int[perm.size()];
        	int i = 0;
        	for (Integer number: perm) {
        		intArray[i] = number;
        		i++;
        	}
        	System.out.print("Before: ");
        	for (int j: intArray) {
        		System.out.print(j + " ");
        	}
        	System.out.println();
        	ob.sort(intArray);
        	System.out.print("After: ");
        	for (int j: intArray) {
        		System.out.print(j + " ");
        	}
        	System.out.println();
        	System.out.println("Total number of Comparisons: " + ob.getComparisons());
            System.out.println();
        }
		
		// CocktailSort
		
		// QuickSort
	}
}