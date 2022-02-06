package QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TimeSortingAlgorithms
 */
public class TimeSortingAlgorithms {

    private static int[] readFile(String fileName){
        int[] arrayOfInts;
        List<Integer> listOfInts = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("Quicksort-algorithm/QuickSort/test_files/"+fileName));
            while(scanner.hasNextInt()){
                listOfInts.add(scanner.nextInt());
            }
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        arrayOfInts = new int[listOfInts.size()];
        for (int i = 0; i < listOfInts.size(); i++) {
            arrayOfInts[i] = listOfInts.get(i);
        }
        return arrayOfInts;
    }

    private static void timeSortingAlg(){       
        
        File dir = new File("Quicksort-algorithm/QuickSort/test_files");
        String[] fileNames = dir.list();
        long startTime;
        long finishTime;
        int[] copyArray;
        int[] arrayOfInts;
        
        for (String fileName : fileNames) {
            
            System.out.println("----------------------------------------");
            System.out.println("Time taken to sort " + fileName);
            System.out.println();            
            
            // run sorting algs:
            arrayOfInts = readFile(fileName);
            
            //* quicksort:
            copyArray = arrayOfInts.clone();
            startTime = System.currentTimeMillis();
            QuickSortAlg.quickSort(arrayOfInts, 0, arrayOfInts.length-1);
            finishTime = System.currentTimeMillis();
            System.out.println("Quicksort: " + (finishTime-startTime) + "ms");
            System.out.println();
            
            //* cutoff quicksort:
            copyArray = arrayOfInts.clone();
            // arrayOfInts = readFile(fileName);
            startTime = System.currentTimeMillis();
            CutOffQuickSort.cutOffQuickSort(arrayOfInts, 0, arrayOfInts.length-1);
            finishTime = System.currentTimeMillis();
            System.out.println("CutoffQuicksort: " + (finishTime-startTime) + "ms");
            System.out.println();
            
            
            //* median quicksort:
            copyArray = arrayOfInts.clone();
            // arrayOfInts = readFile(fileName);
            startTime = System.currentTimeMillis();
            MedianQuickSort.medianQuickSort(arrayOfInts, 0, arrayOfInts.length-1);
            finishTime = System.currentTimeMillis();
            System.out.println("MedianQuicksort: " + (finishTime-startTime) + "ms");
            System.out.println();
            
            
            // //* three way quicksort: WORKED
            copyArray = arrayOfInts.clone();
            // arrayOfInts = readFile(fileName);
            startTime = System.currentTimeMillis();
            ThreeWayQuickSort.threeWayQuickSort(arrayOfInts, 0, arrayOfInts.length-1);
            finishTime = System.currentTimeMillis();
            System.out.println("ThreeWayQuicksort: " + (finishTime-startTime) + "ms");
            System.out.println();

            // //* Insertion sort:
            // copyArray = arrayOfInts.clone();
            // // arrayOfInts = readFile(fileName);
            // startTime = System.currentTimeMillis();
            // InsertionSort.insertionSort(arrayOfInts);
            // finishTime = System.currentTimeMillis();
            // System.out.println("Insertionsprt: " + (finishTime-startTime) + "ms");
            // System.out.println();

            
        }
    }

    public static void main(String[] args) {
        timeSortingAlg();
        // System.out.println(ThreeWayQuickSort.counter);
    }
}
    