package projectOne;

import java.util.Random;

/**
 * This class sorts arrays using the QuickSort algorithm. It keeps track of the
 * number of comparisons made.
 * 
 * @author GeeksforGeeks + Martin Allen
 */
class QuickSort {
	private static int comparisonTracker; // tracks total # of comparisons made

	/**
	 * Constructor. Starting number of comparisons is zero.
	 */
	public QuickSort() {
		comparisonTracker = 0;
	}

	/**
	 * 
	 * @return Number of comparisons made.
	 */
	private static int getComparisons() {
		return comparisonTracker;
	}

	/**
	 * Swaps two elements in an array.
	 * 
	 * @param array
	 * @param position1 first element
	 * @param position2 second element
	 */
	static void swap(int[] array, int position1, int position2) {
		int temp = array[position1]; // Copy the first element

		array[position1] = array[position2]; // Assign position1 with the second element

		array[position2] = temp; // Assign position2 with the first element
	}

	/**
	 * Partitions the array based on the pivot element. Elements smaller than or
	 * equal to the pivot are moved to the left, and elements greater than the pivot
	 * are moved to the right.
	 * 
	 * @param arr  The array to be partitioned.
	 * @param low  The starting index of the subarray to partition.
	 * @param high The ending index of the subarray to partition.
	 * @return The index of the pivot element after partitioning.
	 */
	static int partition(int[] arr, int low, int high) {
		Random rand = new Random();
		int randomPivotIndex = low + rand.nextInt(high - low + 1); // Random pivot between low and high
		
		swap(arr, randomPivotIndex, high); // Swap random pivot with the last element

		int pivot = arr[high]; // Pivot is now the last element after swapping
		int i = (low - 1); // Index of the smaller element

		for (int j = low; j < high; j++) {
			comparisonTracker++; // Comparison made

			// If current element is smaller than or equal to the pivot
			if (arr[j] <= pivot) {
				i++; // Increment the index of the smaller element
				swap(arr, i, j); // Swap arr[i] with arr[j]
			}
		}

		// Swap the pivot element to its correct position
		swap(arr, i + 1, high);

		// Return the partition index
		return i + 1;
	}

	/*
	 * The main function that implements QuickSort arr[] --> Array to be sorted, low
	 * --> Starting index, high --> Ending index
	 */
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[p] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
}
