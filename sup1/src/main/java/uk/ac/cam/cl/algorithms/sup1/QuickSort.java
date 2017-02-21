package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        if (input.size() == 0) {
            return input;
        }
        recursiveSort(input, 0, input.size() - 1);
        return input;
    }

    private void recursiveSort(List<T> input, int start, int end) {
        // The empty list is sorted by definition
        if (start >= end) {
            return;
        }
        // Swap the two elements in the list if necessary
        if (start == end - 1) {
            if (input.get(start).compareTo(input.get(end)) > 0) {
                swap(input, start, end);
                return;
            }
        }

        // The pivot point is chosen to be the median of the first, middle and last element.
        //int pivot = median(input, start, end);
        int pivot = median(input, start, end);
        T pivotVal = input.get(pivot);

        int left = start;
        int right = end;

        while (left <= right) {
            // Shift the left index to the right as long as the element is smaller than the pivot element
            while (input.get(left).compareTo(pivotVal) < 0) {
                left++;
            }

            // Shift the right index to the left as long as the element is greater than the pivot element
            while (input.get(right).compareTo(pivotVal) > 0) {
                right--;
            }

            // If the left and right index have not passed by, swap the elements at left and right
            // and continue shifting
            if (left <= right) {
                swap(input, left, right);
                left++;
                right--;
            }
        }

        if (left < end) {
            recursiveSort(input, start, left);
        }
        if (right > start) {
            recursiveSort(input, right, end);
        }
    }

    private int median(List<T> input, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = (left + right)/2;

        T leftVal = input.get(left);
        T midVal = input.get(mid);
        T rightVal = input.get(right);

        if (leftVal.compareTo(midVal) > 0) {
            if (midVal.compareTo(rightVal) > 0) {
                return mid;
            } else if (leftVal.compareTo(rightVal) > 0) {
                return right;
            } else {
                return left;
            }
        } else {
            if (leftVal.compareTo(rightVal) > 0) {
                return left;
            } else if (midVal.compareTo(rightVal) > 0) {
                return right;
            } else {
                return mid;
            }
        }
    }

    private void swap(List<T> input, int i, int j) {
        if (i == j) {
            return;
        }

        T temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}
