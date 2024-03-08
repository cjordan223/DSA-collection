// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_1.java
 * Abstract: Program to put all negative numbers in front of all positive numbers.
 * Name: Conner Jordan
 * Date: 02-04-24
 */

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    // approach 1
    int[] arr1 = arr.clone();
    rearrangeUsingFirstApproach(arr1);
    printArray(arr1);

    // approach 2
    int[] arr2 = arr.clone();
    rearrangeUsingSecondApproach(arr2);
    printArray(arr2);

    scanner.close();
  }

  private static void rearrangeUsingFirstApproach(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      while (i < j && arr[i] < 0) {
        i++;
      }
      while (i < j && arr[j] >= 0) {
        j--;
      }
      if (i < j) {
        swap(arr, i, j);
      }
    }
  }

  private static void rearrangeUsingSecondApproach(int[] arr) {
    int i = 0, j = 0;
    while (j < arr.length) {
      if (arr[j] < 0) {
        swap(arr, i, j);
        i++;
      }
      j++;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (i > 0) {
        System.out.print(" ");
      }
      System.out.print(arr[i]);
    }
    System.out.println();
  }
}
