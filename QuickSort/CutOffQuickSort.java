package QuickSort;

import java.util.Arrays;

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
        int k = 500;
        // index of middle element which splits A into two sub arrays:
        int q;

        // if the range of the array to be sorted is less than that threshold, return sort with insertionSort() as it has better running time with small arrays:
        if ((r-p) <= k) {
            insertionSort(A);
        }
        
        if (p < r && A.length > k) {
            q = Partition.partition(A, p, r);

            if (q-p <= r-(q+1)){
                cutOffQuickSort(A, p, q-1);
                p = q+1;
            } else {
                cutOffQuickSort(A, q+1, r);
                r=q;
            }
        }
        
        return A;
    }

    // public static void main(String[] args) {
    //     long startTime;
    //     long finishTime;
    //     int[] A = {0,1,7,3,5,2,3,8};
    //     int[] B = InputSeqGen.seqGen(10_00000);
    //     int[] C = InputSeqGen.seqGen(50_000);

    //     startTime = System.currentTimeMillis();
    //     cutOffQuickSort(B, 0, B.length-1);
    //     finishTime = System.currentTimeMillis();
    //     System.out.println("cutoff quicksort B: " + (finishTime-startTime) + "ms");

    //     startTime = System.currentTimeMillis();
    //     cutOffQuickSort(C, 0, C.length-1);
    //     finishTime = System.currentTimeMillis();
    //     System.out.println("cutoff quicksort C: " + (finishTime-startTime) + "ms");
    //     System.out.println(Arrays.toString(B));
    // }
}
