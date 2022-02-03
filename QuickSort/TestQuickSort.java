package QuickSort;

import java.util.Arrays;

public class TestQuickSort {
    
    private static boolean equalArrays(int[] A, int[] A_sorted){
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
        // int[] B = new int[] {0,7,5,2,4,4,1,3};
        // cutOffQuickSort(B, 0, B.length-1);
        // System.out.println("Cutoff Quicksort: " + equalArrays(B, sorted));
        // System.out.println();

        //* 1c:
        int[] C = new int[] {7,5,2,4,6,4,1,3,7,0};
        MedianQuickSort.medianQuickSort(C, 0, C.length-1);
        System.out.println(Arrays.toString(C));
        System.out.println("Median-of-three Quicksort: " + equalArrays(C, sorted));
        System.out.println();
        
        
    }
}
