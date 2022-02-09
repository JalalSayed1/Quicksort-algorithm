package QuickSort;

public class Swap {

    /**
     * To swap two element in an array of ints.
     * @param A array of ints
     * @param first first element's index
     * @param second second element's index
     * @return array A with the two elements swapped
     */
    protected static int[] swap(int[] A, int first, int second){
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;
        return A;
    }
}
