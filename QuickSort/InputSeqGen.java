package QuickSort;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class InputSeqGen {

    /**
     * 
     * @param arrayLen number of elements in the array returned (inclusive)
     * @return array of ints
     */
    protected static int[] seqGen(int arrayLen){
        Random random = new Random();
        Set<Integer> setOfInts = new LinkedHashSet<Integer>();
        int[] arrayOfInts = new int[arrayLen];

        while(setOfInts.size() != arrayLen){
            setOfInts.add(random.nextInt());
        }

        int indx = 0;
        for (int elt : setOfInts) {
            arrayOfInts[indx++] = elt;
        }
        return arrayOfInts;
    }

    protected static void quicksortQuadraticTime(int seqLen){
        long startTime;
        long finishTime;

        int[] array = seqGen(seqLen);
        QuickSortAlg.quickSort(array, 0, array.length-1);

        startTime = System.currentTimeMillis();
        QuickSortAlg.quickSort(array, 0, array.length-1);
        finishTime = System.currentTimeMillis();
        System.out.println("O(n^2) Quicksort: " + (finishTime-startTime) + "ms");
    }

    public static void main(String[] args) {
        quicksortQuadraticTime(14000);
    }
}
