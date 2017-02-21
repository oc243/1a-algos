package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {

    SortingAlgorithm sortingAlgorithm;

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        List emptyList = new ArrayList();
        assertEquals(emptyList, sortingAlgorithm.sort(emptyList));
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        List oneElementList = new ArrayList();
        oneElementList.add(1);
        assertEquals(oneElementList, sortingAlgorithm.sort(oneElementList));
    }

    public void testSortingAListReturnsASortedList() {
        List nonSortedList = new ArrayList();
        nonSortedList.add(1);
        nonSortedList.add(2);
        nonSortedList.add(0);
        nonSortedList.add(0);
        nonSortedList.add(5);
        nonSortedList.add(-1);
        nonSortedList.add(-4);
        nonSortedList.add(-2);
        nonSortedList.add(4);

        assertTrue(sorted(sortingAlgorithm.sort(nonSortedList)));
    }

    private boolean sorted(List<Comparable> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }

        return true;
    }

    public SortingAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Parameterized.Parameters
    public static Collection<SortingAlgorithm[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()}
        );
    }

}