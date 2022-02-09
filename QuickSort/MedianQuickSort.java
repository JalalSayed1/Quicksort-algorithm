package QuickSort;

import java.util.Arrays;

public class MedianQuickSort {
    
    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return the median between p, q and r
     */
    private static int medianOfThreePartition(int[] A, int p, int r){

    	int mid = (p+r)/2;
        int high = r;
        int low = p;
    	int temp;
    	
    	if (A[mid] < A[low]) {
            Swap.swap(A, mid, low);
    	}
    	if (A[high] < A[low]) {
            Swap.swap(A, high, low);
    	}
    	if (A[mid] < A[high]) {
            Swap.swap(A, mid, high);
    	}
    	
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

        // put A[r] in the right place:
        Swap.swap(A, i+1, r);

        return i+1;
    	
        }

    public static int[] medianQuickSort(int[] A, int p, int r){

        int q;
        if (p < r) {
            q = medianOfThreePartition(A, p, r);

			if (q-p <= r-(q+1)){
				medianQuickSort(A, p, q-1);
				p = q+1;
            } else {
				medianQuickSort(A, q+1, r);
                r=q;
            }
        }
        return A;
    }

}
