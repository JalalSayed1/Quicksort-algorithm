package QuickSort;

public class CutOffQuickSort {
    
    /**
     * Insertion sort algorithm to be used with the Quicksort variant with cuts off if array length is less than k.
     * @param A array of ints
     * @return sorted array A 
     */
    private static int[] insertionSort(int[] A){
        int i;
        int key;
        for(int j=1; j<A.length; j++){
            key = A[j];
            i = j-1;
            while(i>=0 && A[i]>key){
                A[i+1] = A[i];
                i = i-1;
            }
            A[i+1] = key;
        }
        return A;
    }

    /**
     * A variant of QUICKSORT which returns without sorting subarrays with fewer than k elements and then uses INSERTION-SORT to sort the entire nearly-sorted array
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return sorted array A[p..r]
     */
    public static int[] cutOffQuickSort(int[] A, int p, int r){

        // array length less than 5 will be be sorted:
        int k = 6;
        // index of middle element which splits A into two sub arrays:
        int q;

        // if the range of the array to be sorted is less than that threshold, return sort with insertionSort() as it has better running time with small arrays:
        if ((r-p) <= k) {
            //! System.out.println("Calling insertion sort now..");
            insertionSort(A);
            
        }
        
        if (p < r && A.length > k) {
            q = Partition.partition(A, p, r);

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
            
            cutOffQuickSort(A, p, q-1);
            cutOffQuickSort(A, q+1, r);

        }
        
        return A;
    }
}
