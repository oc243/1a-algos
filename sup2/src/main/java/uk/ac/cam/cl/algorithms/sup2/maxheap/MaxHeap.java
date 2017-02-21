package uk.ac.cam.cl.algorithms.sup2.maxheap;

import uk.ac.cam.cl.algorithms.sup1.HeapSizeExceededException;

import java.util.List;

public class MaxHeap<T extends Comparable> implements MaxHeapInterface<T> {

    private static int MAX_ELEMENTS_IN_HEAP = 1000;
    private T[] mHeap;
    private int mSize;

    /**
     * Constructs a heap from the given elements
     * @param elements Elements to be placed in the heap
     * @throws HeapSizeExceededException If there are more elements given than the heap can hold
     */
    public MaxHeap(List<T> elements) throws HeapSizeExceededException {
        mSize = elements.size();
        mHeap = (T[])new Object[MAX_ELEMENTS_IN_HEAP];

        if (elements.size() == 0) {
            return;
        }

        // Copy the given array to the heap array
        for (int i = 0; i < elements.size(); i++) {
            mHeap[i] = elements.get(i);
        }

        // Bottom-up, convert the array into a heap
        for (int i = (getLength() - 1) / 2; i>= 0; i--) {
            maxHeapify(i);
        }
    }

    // Get and remove the maximum value
    public T getMax() throws EmptyHeapException {
        if (mHeap == null || getLength() == 0) {
            throw new EmptyHeapException();
        }

        // Temporarily store the return value
        T top = mHeap[0];

        // Place the last item of the heap on top
        mHeap[0] = mHeap[--mSize];

        // Turn the array into a heap again
        maxHeapify(0);

        return top;
    }

    // Insert the element in the heap
    public void insert(T i) throws HeapSizeExceededException {
        // Place the character at the end of the list and let it 'bubble up' to the correct position in the heap
        mHeap[getLength()] = i;
        bubbleUp(getLength());

        mSize++;
    }

    // Assuming the heap is correct (except for possibly the item at the given index and its parent), the item will be
    // 'bubbled up' to its correct place
    private void bubbleUp(int index) {
        // by assumption already in the right place
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        // while the item is greater than its parent, continue 'bubbling up'
        if (mHeap[parentIndex].compareTo(mHeap[index]) < 0) {
            swapElements(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    // assuming the two subtrees of item {index} are heaps, we place the item {index} in the correct place
    private void maxHeapify(int index) {
        // largestIndex represents the index of the item which is the largest
        int largestIndex = index;

        // indices of the two subtrees
        int leftIndex = 2 * index + 1;
        int rightIndex = leftIndex + 1;

        // if necesarry change largestIndex
        if (leftIndex < getLength() && mHeap[leftIndex].compareTo(mHeap[largestIndex]) > 0) {
            largestIndex = leftIndex;
        }
        if (rightIndex < getLength() && mHeap[rightIndex].compareTo(mHeap[largestIndex]) > 0) {
            largestIndex = rightIndex;
        }

        // If the current item is not the largest, it is out of place and need to be swapped.
        // The according subtrees will be recursively heapified.
        if (largestIndex != index) {
            swapElements(largestIndex, index);
            maxHeapify(largestIndex);
        }
    }

    // swap two elements in the heap
    private void swapElements(int k, int l) {
        T tmp = mHeap[k];
        mHeap[k] = mHeap[l];
        mHeap[l] = tmp;
    }

    public int getLength() {
        return mSize;
    }
}
