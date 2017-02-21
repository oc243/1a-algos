package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        if (input.size() == 0) {
            return input;
        }
        recursiveSort(input, 0, input.size() - 1);
        return input;
    }

    /**
     * Recursive function for sorting a list using Merge sort.
     * @param input The list to be sorted in-place
     * @param start The index of the first element of the range to be sorted
     * @param end The index of the last element of the range to be sorted
     */
    private List<T> recursiveSort(List<T> input, int start, int end) {
        // Base case
        if (start == end) {
            return input;
        }

        // Divide
        int mid = (start + end)/2;
        input = recursiveSort(input, start, mid);
        input = recursiveSort(input, mid + 1, end);

        // Conquer
        return merge(input, start, end);
    }

    /**
     * Represents the conquer stage of the divide-and-conquer algorithm Merge sort.
     * @param input The list to be sorted in-place.
     * @param start The index of the first element of the first of the two sorted sub-lists
     * @param end The index of the last element of the second of the two sorted sub-lists
     */
    private List<T> merge(List<T> input, int start, int end) {
        List<T> sortedList = new ArrayList<T>();

        int mid = (start + end)/2;

        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            // Check if input[i] is smaller than input[j]
            if (input.get(i).compareTo(input.get(j)) < 0) {
                sortedList.add(input.get(i));
                i++;
            } else {
                sortedList.add(input.get(j));
                j++;
            }
        }
        // Fill up the rest of the list
        if (i <= mid && j > end) {
            for (int k = i; k <= mid; k++) {
                sortedList.add(input.get(k));
            }
        }
        if (i > mid && j <= end) {
            for (int k = j; k <= end; k++) {
                sortedList.add(input.get(k));
            }
        }

        // Copy the elements of the sorted sub-list to the main list
        for (int k = 0; k <= (end - start); k++) {
            input.set(k + start, sortedList.get(k));
        }

        return input;
    }
}
