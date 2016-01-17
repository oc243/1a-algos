package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public interface SortingAlgorithm<T extends Comparable> {

   public List<T> sort(List<T> input);

}
