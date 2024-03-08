// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_2.java
 * Abstract: Program to find the largest integer in an array of integers, using a recursive "divide and conquer" algorithm.
 * Name: Conner Jordan
 * Date: 02-04-24
 */

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int size = scnr.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = scnr.nextInt();

        }

        int max = findMax(numbers, 0, numbers.length - 1);
        System.out.println(max);
    }

    public static int findMax(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }

        int mid = start + (end - start) / 2;

        int max1 = findMax(array, start, mid);
        int max2 = findMax(array, mid + 1, end);

        return Math.max(max1, max2);
    }
}
