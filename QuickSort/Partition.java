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
        /* 
         * Pseudo code: 
        PARTITION(A,p,r)
            x := A[r]
            i := p – 1
            for j = p to r - 1
                if A[j] <= x
                    i := i + 1
                    SWAP(A[i],A[j])
            SWAP(A[i+1],A[r]) 
            return i + 1
         */
        int x = A[r];
        int i = p-1;
        int temp; // for swapping

        // stop just before the last elt:
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i += 1;
                // perform the SWAP:
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            // System.out.println(Arrays.toString(A));
        }

        // perform the last SWAP:
        temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        //! System.out.println(Arrays.toString(A));
        return i+1;
    }

}
