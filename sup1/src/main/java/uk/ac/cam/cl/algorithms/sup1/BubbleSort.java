package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        int length = input.size();

        // A maximum of 'length' sweeps through the list are required to sort it using bubble sort
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                // Test if two elements are out of order and if so, then swap them
                if (input.get(j).compareTo(input.get(j - 1)) < 0) {
                    T temp = input.get(j);
                    input.set(j, input.get(j - 1));
                    input.set(j - 1, temp);
                }
            }
        }

        return input;
    }
}
