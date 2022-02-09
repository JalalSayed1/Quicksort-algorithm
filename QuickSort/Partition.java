package QuickSort;

public class Partition {
    
    /**
     * Normal partitioning scheme for Quicksort
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return index such that A[p..q-1] <= A[q] < A[q+1..r]
     */
    protected static int partition(int[] A, int p, int r){

        int x = A[r];
        int i = p-1;

        // stop just before the last elt:
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i += 1;
                // perform the SWAP:
                Swap.swap(A, i, j);
            }
        }

        // perform the last SWAP:
        Swap.swap(A, i+1, r);

        return i+1;
    }

}
