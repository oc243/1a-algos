package uk.ac.cam.cl.algorithms.sup2.maxheap;

import uk.ac.cam.cl.algorithms.sup1.HeapSizeExceededException;

import java.util.Comparator;

public interface MaxHeapInterface<T> {
    // get the maximum value (or exception if empty)
    public T getMax() throws EmptyHeapException;
    // insert a new value into the heap (or exception if full)
    public void insert(T i) throws HeapSizeExceededException;
}
