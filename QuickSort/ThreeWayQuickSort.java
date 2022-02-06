package QuickSort;

import java.util.Arrays;

public class ThreeWayQuickSort {

    /**
     * 
     * @param A array of ints
     * @param fromIndex index of the first element to be shifted in array A
     * @param eltIndex index of the last element in the array to be shifted. This is also the index of the element to be placed in the right place
     * @return array with two indexes: last index of the left array (includes elts < pivot) and last index of the mid array (includes elts = pivot)
     */
    private static int[] putValueAndShiftArray(int[] A, int fromIndex, int eltIndex){
        // put the value in the right place:
        int temp = A[eltIndex];

        // shift array to right:
        // eltIndex is the end index so will shift values from fromIndex to eltIndex
        for (int i =eltIndex-1; i >= fromIndex ; i-- ){
            A[i+1] = A[i];
        }

        // put the elt in the right place now after shifting the array:
        A[fromIndex] = temp;

        return A;
    }
    
    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return
     */
    private static int[] threeWayPartitioning(int[] A, int p, int r){
        /**
         * take pivot = last elt
         * first index = end of left array with elts < pivot = start index-1
         * second index = end of mid array with elts equals pivot = start index-1
         * 
         * loop through the array:
         * if > pivot, do nothing
         * if < pivot, put it at index first+1 then shift every thing else by 1 and increment first and second by 1
         * if = pivot, put it at index sec+1 then shift every thing else by 1 and increment ONLY second by 1
         * 
         * result:
         * first array from index 0 => first
         * mid array from index first+1 => second
         * last array from index second+1 => r (end of array)
         * 
         */

        int pivot = A[r];
        
        int firstIndex = p-1;
        int secondIndex = p-1; // start indexes at the same point
        int[] indexes = new int[2];

        for (int j = p; j < r; j++) {
            if (A[j] < pivot) {
                firstIndex += 1;
                // put the value at first index then shift the rest of the array to the right:
                putValueAndShiftArray(A, firstIndex, j);
                secondIndex += 1;

            } else if (A[j] == pivot){
                secondIndex += 1; // only increment second index
                putValueAndShiftArray(A, secondIndex, j);
            }
        }
        
        // put pivot at secondIndex+1 (at the end of the mid array):
        secondIndex += 1;
        putValueAndShiftArray(A, secondIndex, r);
        // System.out.println("Arrays after partitioning: " + Arrays.toString(A));
        
        indexes[0] = firstIndex;
        indexes[1] = secondIndex;
        // System.out.println("Returning from partitioning: " + Arrays.toString(indexes));
        return indexes;
    }

    /**
     * 
     * @param A = array of ints
     * @param p = start index
     * @param r = last index
     * @return sorted array A[p..r]
     */
    public static int[] threeWayQuickSort(int[] A, int p, int r){

        // index of middle element which splits A into two sub arrays:
        int[] indexes;

        if (p < r){
            indexes = threeWayPartitioning(A, p, r);
            threeWayQuickSort(A, p, indexes[0]);
            threeWayQuickSort(A, indexes[1]+1, r);
        }

        return A;
    }

    public static void main(String[] args) {
        int[] B = {0,7,3,5,2,3};
        int[] A = {0,1,7,3,5,2,3,8};
        // int fromIndex = 1;
        // int eltIndex = 3;
        threeWayQuickSort(B, 0, B.length-1);
        System.out.println(Arrays.toString(B));
        
    }

}
