package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        // Insert new elements one-by-one in the correct place
        for (int i = 1; i < input.size(); i++) {
            int j = i;

            while (j > 0 && input.get(j).compareTo(input.get(j - 1)) < 0) {
                // Swap the elements
                T temp = input.get(j);
                input.set(j, input.get(j - 1));
                input.set(j - 1, temp);
                j--;
            }
        }

        return input;
    }
}
