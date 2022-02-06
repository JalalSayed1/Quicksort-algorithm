package QuickSort;

import java.util.Arrays;

/**
 * QuickSort
 */
public class QuickSortAlg {

    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return sorted array A[p..r]
     */
    public static int[] quickSort(int[] A, int p, int r){

        // index of middle element which splits A into two sub arrays:
        int q;

        if (p < r){
            q = Partition.partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
        
        // System.out.println(Arrays.toString(A));
        return A;
    }
    
}