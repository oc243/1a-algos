package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;
import uk.ac.cam.cl.algorithms.sup1.HeapSizeExceededException;
import uk.ac.cam.cl.algorithms.sup2.maxheap.EmptyHeapException;
import uk.ac.cam.cl.algorithms.sup2.maxheap.MaxHeap;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) throws HeapSizeExceededException{
        MaxHeap<T> heap = new MaxHeap<T>(input);

        List<T> sorted = new ArrayList<T>(heap.getLength());
        for (int i = 0; i < heap.getLength(); i++) {
            try {
                sorted.set(heap.getLength() - 1 - i, heap.getMax());
            } catch (EmptyHeapException e) {
                System.out.println("Something has gone terribly wrong here. " +
                        "The new heap should have the size of the input list.");
            }
        }

        return sorted;
    }

}