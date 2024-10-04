package projectOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestDriver {

    public static void main(String[] args) {
        int[] nValues = {4, 6, 8};

        for (int n : nValues) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            List<List<Integer>> allPermutations = PermutationGenerator.generatePermutations(arr);

            List<int[]> originalPermutations = new ArrayList<>();
            List<Integer> heapSortComparisons = new ArrayList<>();
            List<Integer> mergeSortComparisons = new ArrayList<>();
            List<Integer> cocktailSortComparisons = new ArrayList<>();
            List<Integer> quickSortComparisons = new ArrayList<>();

            for (List<Integer> perm : allPermutations) {
                int[] intArray = perm.stream().mapToInt(i -> i).toArray();
                originalPermutations.add(intArray.clone());

                // Heap Sort
                HeapSort heapSort = new HeapSort();
                heapSort.sort(intArray.clone());
                heapSortComparisons.add(heapSort.getComparisons());

                // Merge Sort
                MergeSort mergeSort = new MergeSort();
                mergeSort.sort(intArray.clone(), 0, intArray.length - 1);
                mergeSortComparisons.add(mergeSort.getComparisons());

                //Cocktail Sort
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.sort(intArray.clone());
                cocktailSortComparisons.add(cocktailSort.getComparisons());

                // Quick Sort
                QuickSort quickSort = new QuickSort();
                quickSort.sort(intArray.clone(), 0, intArray.length - 1);
                quickSortComparisons.add(quickSort.getComparisons());
            }

            // Analyze and process collected data for this 'n'

            analyzeResults("Heap Sort", n, originalPermutations, heapSortComparisons);
            analyzeResults("Merge Sort", n, originalPermutations, mergeSortComparisons);
            analyzeResults("Quick Sort", n, originalPermutations, quickSortComparisons);
            analyzeResults("Cocktail Sort", n, originalPermutations, cocktailSortComparisons);

        }
    }

    private static void analyzeResults(String algorithmName, int n, List<int[]> originalPermutations, List<Integer> comparisons) {
        System.out.println("\nAnalysis for " + algorithmName + " (n = " + n + ")");
        System.out.println("========================================================");

        // Best 10 Cases
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < originalPermutations.size(); i++) {
            results.add(new Result(originalPermutations.get(i), comparisons.get(i)));
        }
        Collections.sort(results);
        System.out.println("Best 10 Cases:");
        for (int i = 0; i < 10 && i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        System.out.println();
        // Average Case
        int totalComparisons = comparisons.stream().mapToInt(Integer::intValue).sum();
        double averageComparisons = (double) totalComparisons / comparisons.size();
        System.out.println("Average Case Performance: " + averageComparisons + " comparisons");
        System.out.println();

        // Worst 10 Cases
        Collections.reverse(results); // Reverse the sorted list
        System.out.println("Worst 10 Cases:");
        for (int i = 0; i < 10 && i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    // Helper class to store permutation and comparison count
    static class Result implements Comparable<Result> {
        int[] permutation;
        int comparisons;

        public Result(int[] permutation, int comparisons) {
            this.permutation = permutation;
            this.comparisons = comparisons;
        }

        @Override
        public int compareTo(Result other) {
            return Integer.compare(this.comparisons, other.comparisons);
        }

        @Override
        public String toString() {
            return "Permutation: " + java.util.Arrays.toString(permutation) + 
                   ", Comparisons: " + comparisons;
        }
    }
}