// Author: Conner Jordan
// Title: Main_hw3_1
// Abstract: Program to read an array of numbers and sort in ascending order. Then, the program cosolidates values that are adjacent to eachother.
// Date: 1-17-24

import java.util.Scanner;

class Main {

    private static void printNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return;

        int end = numbers[0];
        int start = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == end + 1) {
                end = numbers[i];
            } else {
                printLocal(start, end);
                System.out.print(" ");
                start = end = numbers[i];
            }
        }

        printLocal(start, end);
    }

    private static void printLocal(int start, int end) {
        if (start == end) {
            System.out.print(start);
        } else {
            System.out.print(start + "-" + end);
        }
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int arrSize = scnr.nextInt();
        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = scnr.nextInt();
        }

        for (int i = 0; i < arrSize - 1; i++) {

            for (int j = 0; j < arrSize - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }

        printNumbers(arr);
        System.out.println();

    }

}
