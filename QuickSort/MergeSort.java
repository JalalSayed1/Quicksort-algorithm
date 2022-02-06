package QuickSort;

import java.util.Arrays;

public class MergeSort {
    /**
     * 
     * @param A array of ints
     * @param p start index
     * @param q middle index
     * @param r end 
     * @return
     */
    protected static int[] mergeSort(int[] A, int p, int q, int r){ 
        int n1 = q - p + 1; // first half of the array
        int n2 = r - q; // second half
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        // System.out.println("n1 n2: " + n1 +" "+ n2);

        for (int i=p; i<q+1; i++){
            L[i] = A[i];
        }
        
        // L = Arrays.copyOfRange(A, p, q);
        // System.out.println("L is " + Arrays.toString(L));
        for (int i=q+1; i<r+1; i++){
            R[i-n1] = A[i]; // current index - size of the first half of A
        }
        // R = Arrays.copyOfRange(A, q+1, r);
        // System.out.println("R is " + Arrays.toString(R));

        double inf = Double.POSITIVE_INFINITY;
        L[n1] = (int) inf;
        R[n2] = (int) inf;
        // System.out.println("L is " + Arrays.toString(L));
        // System.out.println("R is " + Arrays.toString(R));

        int i=0;
        int j=0;
        for (int k=p; k<r+1; k++){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[] a = {2,5,6,1,0,5};
        System.out.println(Arrays.toString(mergeSort(a, 0, 3, 5)));
    }
}
