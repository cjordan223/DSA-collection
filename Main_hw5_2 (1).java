 /*
 * Title: Main_hw5_2.java
 * Abstract: Java program to compare effeciency of quicksort vs merge sort
 * Name: Conner Jordan
 * Date: 2-13-24
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input size: ");
        int size = scanner.nextInt();
        Random random = new Random();

         int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt();
        }

         int[] numbersForQuickSort = numbers.clone();

         long startTime = System.nanoTime();
        MergeSort.sort(numbers);
        long endTime = System.nanoTime();
        long mergeSortTime = (endTime - startTime) / 1000000;  

         startTime = System.nanoTime();
        QuickSort.sort(numbersForQuickSort, 0, numbersForQuickSort.length - 1);
        endTime = System.nanoTime();
        long quickSortTime = (endTime - startTime) / 1000000;  

         System.out.println("\n===================== Execution Time ====================");
        System.out.println("Merge sort:   " + mergeSortTime + " milliseconds");
        System.out.println("Quick sort:   " + quickSortTime + " milliseconds");
        System.out.println("=========================================================");
    }
}

class MergeSort {
    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}

class QuickSort {
    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);

            sort(array, start, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }
}
