package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.HeapSizeExceededException;
import uk.ac.cam.cl.algorithms.sup2.HeapSort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SortingAlgorithmTest extends junit.framework.TestCase {

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        List<Integer> toBeSorted = new ArrayList<>(0);
        HeapSort<Integer> sort = new HeapSort<>();
        List<Integer> sortedList = new ArrayList<>();
        try {
            sortedList = sort.sort(toBeSorted);
        } catch (HeapSizeExceededException e) {
            fail();
        }

        assert sortedList.size() == 0;
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        List<Integer> toBeSorted = new ArrayList<>(1);
        toBeSorted.set(0, 1);
        HeapSort<Integer> sort = new HeapSort<>();
        List<Integer> sortedList = new ArrayList<>();
        try {
            sortedList = sort.sort(toBeSorted);
        } catch (HeapSizeExceededException e) {
            fail();
        }

        assert sortedList.size() == 1;
        assert sortedList.get(0).equals(1);
    }

    @Test
    public void testSortingAnList() {
        List<Integer> nonSortedList = new ArrayList<>();
        nonSortedList.add(1);
        nonSortedList.add(2);
        nonSortedList.add(0);
        nonSortedList.add(0);
        nonSortedList.add(5);
        nonSortedList.add(-1);
        nonSortedList.add(-4);
        nonSortedList.add(-2);
        nonSortedList.add(4);

        HeapSort<Integer> sort = new HeapSort<>();
        List<Integer> sortedList = new ArrayList<>();
        try {
            sortedList = sort.sort(nonSortedList);
        } catch (HeapSizeExceededException e) {
            fail();
        }

        assert sortedList.size() == nonSortedList.size();
        assert haveSameElements(nonSortedList, sortedList);
        assert isSorted(sortedList);
    }

    private boolean haveSameElements(List a, List b) {
        // Check if a and b are the same
        // for all x. (x in a <=> x in b)

        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i))) {
                return false;
            }
        }

        for (int i = 0; i < b.size(); i++) {
            if (!a.contains(b.get(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(List<Integer> a) {
        // Check if any element is out of order
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1).compareTo(a.get(i)) > 0) {
                return false;
            }
        }

        return true;
    }
}
