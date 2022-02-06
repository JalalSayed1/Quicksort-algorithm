package QuickSort;

public class InsertionSort {
    public static int[] insertionSort(int[] A){
        int i;
        int key;
        for(int j=1; j<A.length; j++){          // O(n)
            key = A[j];                         // O(1)
            i = j-1;
            while(i>=0 && A[i]>key){            // O(n)
                A[i+1] = A[i];
                i = i-1;
            }
            A[i+1] = key;                      // O(1)
        }
        return A;                             // O(1)
    }
}
