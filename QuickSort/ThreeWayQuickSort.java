package QuickSort;

public class ThreeWayQuickSort {
    
    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return
     */
    private static int[] threeWayPartitioning(int[] A, int p, int r){
        /**
         * less than pivot to the left
         * equals pivot in the center
         * greater than pivot to the right
         * 
         * return 2 indexes
         */

        int x = A[r];
        
        int firstIndex = p-1;
        int secondIndex = p-1; // start indexes at the same point
        int[] indexes = {firstIndex, secondIndex};

        // stop just before the last elt:
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                firstIndex += 1;
                // move the element = pivot to the right:
                for (int i = 0; i < indexes.length; i++) {
                    Swap.swap(A, secondIndex, secondIndex+1);
                }
                secondIndex += 1;
                // perform the SWAP:
                A = Swap.swap(A, firstIndex, j);
            }
            // System.out.println(Arrays.toString(A));
        }

        // perform the last SWAP:
        A = Swap.swap(A, i+1, r);
        // System.out.println(Arrays.toString(A));
        
        return indexes;
    }

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
        int[] indexes;

        if (p < r){
            indexes = threeWayPartitioning(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }

        return A;
    }

}
