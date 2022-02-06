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
    	/*
    	 * mid := (low+high)/2
    	 * if A[mid] < A[low]
    	 * 		SWAP A[low] with A[mid]
    	 * if A[high] < A[low]
    	 * 		SWAP A[low] with A[high]
    	 * if A[mid] < A[high]
    	 * 		SWAP A[mid] with A[high]
    	 * 
    	 * pivot := A[high]
    	 * 
    	 */
    	// System.out.println(Arrays.toString(A));
    	
    	int mid = (p+r)/2;
        int high = r;
        int low = p;
    	// System.out.println(mid);
    	int temp;
    	
    	if (A[mid] < A[low]) {
    		temp = A[mid];
    		A[mid] = A[low];
    		A[low] = temp;
    	}
    	if (A[high] < A[low]) {
    		temp = A[high];
    		A[high] = A[low];
    		A[low] = temp;
    	}
    	if (A[mid] < A[high]) {
    		temp = A[mid];
    		A[mid] = A[high];
    		A[high] = temp;
    	}
    	

		int x = A[r];
        int i = p-1;
        // int temp; // for swapping

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

        // put A[r] in the right place:
        temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
		// int q = Partition.partition(A, p, r);

    	// return q;
    	
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
