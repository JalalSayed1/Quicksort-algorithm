# Quicksort-algorithm
## About the project:
- Variant implementations of the Quicksort algorithm. This was my Assessed Exercise 1 for Algorithms &amp; Data Structure 2 (COMPSCI2007) course.
- QuickSort has Best case running time = **O(nlogn)**, average time = **O(nlogn)** and worst time =** O(n^2)**
- Space complexity of the algorithm = **O(logn)**
- The algorithm is **Stable**
- CutOffQuickSort uses InsertionSort to sort the array when its length becomes samll enough, making use of the fact running time of InsertionSort with small arrays.
- MedianQuickSort uses the median of three (first, middle, last) element to use as the "pivot". This prevent the algorithm from getting to its worst case running time.
- ThreeWayQuickSort splits the array into three regions: < pivot, = pivot and > pivot. This algorithm is the most effecient one if we are sure that our array has a lot of duplicates.

## What did I learn from this:
- Different types of QuickSort using different partitioning schemes and their benefits depending on the input array characteristics.
- Time complexity of algorithms and how to calculate Best, Average and worst running times.
- Recurrence algorrithms.
- Recurrsion trees.
- Divide-and-Conquer approach
