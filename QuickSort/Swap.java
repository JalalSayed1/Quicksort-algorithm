package QuickSort;

public class Swap {
    public static int[] swap(int[] A, int first, int second){
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;
        return A;
    }
}