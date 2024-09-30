package p01;

//Java program for implementation of Heap Sort
public class HeapSort {
	int comparisons = 0;
	
	public int getComparisons() {
		return comparisons;
	}
	
	public void sort(int arr[])
	{
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n) {
			comparisons++;
			if (arr[l] > arr[largest]) {
				largest = l;
			}
		}

		

//		// If right child is larger than largest so far
		if (r < n) {
			comparisons++;
			if (arr[r] > arr[largest]) {
				largest = r;
			}
		}

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
//	private static int numComparisons() {
//		return comparisons;
//	}

	// Driver program
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int secondArr[] = { 11, 11, 13, 5, 6, 4 };

		HeapSort ob = new HeapSort();
		System.out.println("Unsorted Array: ");
		printArray(arr);
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
		System.out.println("Number of Comparisons: " + ob.getComparisons());
		
		HeapSort ob2 = new HeapSort();
		
		System.out.println("Unsorted Array: ");
		printArray(secondArr);
		ob2.sort(secondArr);

		System.out.println("Sorted array is");
		printArray(secondArr);
		System.out.println("Number of Comparisons: " + ob2.getComparisons());
		
		
		
	}
}
