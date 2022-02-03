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
    	System.out.println(Arrays.toString(A));
    	
    	int mid = (p+r)/2;
        int high = r;
        int low = p;
    	System.out.println(mid);
    	int temp;
    	
    	if (A[mid] < A[low]) {
    		temp = A[mid]; //! put the swapping in sep file then import
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
    	
    	System.out.println(Arrays.toString(A));
    	System.out.println();
//    	System.out.println("last elt is " + A[r]);
    	return r;
    	
    	
//        int x = A[r];
//        int i = p-1;
//        int temp; // for swapping        
		/*
		 * int pValue = A[p]; int qValue = A[i+1]; int rValue = A[r];
		 * 
		 * // a=p, b=q, c=r => median = max(min(a,b), min(max(a,b),c)) int median =
		 * Math.max(Math.min(pValue,qValue), Math.min(Math.max(pValue,qValue), rValue));
		 * if (median == pValue){ return p; } else if (median == qValue){ return i+1; }
		 * else{ return r; }
		 */
        }

    public static int[] medianQuickSort(int[] A, int p, int r){

        int q;
        if (p < r) {
            q = medianOfThreePartition(A, p, r);

            //! System.out.println("q is: " + A[q]);
            //! System.out.println("less than q:");
            //! for (int i = 0; i < A.length; i++) {
            //!     if(A[i] < A[q]){
            //!         System.out.print(A[i] + " ");
            //!     }
            //! }
            //! System.out.println();
            //! System.out.println("bigger than q:");
            //! for (int i = 0; i < A.length; i++) {
            //!     if(A[i] > A[q]){
            //!         System.out.print(A[i]);
            //!     }
            //! }
            
            medianQuickSort(A, p, q-1);
            medianQuickSort(A, q+1, r);
        }
        return A;
    }

}
