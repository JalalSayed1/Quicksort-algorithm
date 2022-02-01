
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * QuickSort
 */
public class QuickSort {

    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return index such that A[p..q-1] <= A[q] < A[q+1..r]
     */
    private static int partition(int[] A, int p, int r){
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
            q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }

        return A;
    }

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
            q = partition(A, p, r);

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










    public static boolean equalArrays(int[] A, int[] A_sorted){
        boolean equal = true;
        for(int i=0; i<A.length; i++){
            if(A[i] != A_sorted[i]){
                equal = false;
                break;
            }
        }
        return equal;
    }

    public static void main(String[] args) {

        System.out.println();
        int[] sorted = {0,1,2,3,4,1,2,4,5,7};

        //* 1a:
        // int[] A = new int[] {0,7,5,2,4,4,1,3};
        // quickSort(A, 0, A.length-1); // r = len-1
        // System.out.println("Quicksort: " + equalArrays(A, sorted));
        // System.out.println();

        //* 1b:
        int[] B = new int[] {0,7,5,2,4,4,1,3};
        cutOffQuickSort(B, 0, B.length-1);
        System.out.println("Cutoff Quicksort: " + equalArrays(B, sorted));
        System.out.println();
        
        
    }
    
}