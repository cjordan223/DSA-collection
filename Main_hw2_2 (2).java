// Title: Main_Hw2_2
// Abstract: Reads a set of elements from the user, generates and prints all possible subsets along with their binary representations and indices.
// Name: Conner Jordan
// Date: 1-16-2024

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] elements = new String[n];

        // read each element into array
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.next();
        }

        // Generate all subsets of the elements
        for (int i = 0; i < (1 << n); i++) {
            String binaryString;
            if (n > 1) {

                binaryString = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            } else {

                binaryString = Integer.toBinaryString(i);
            }

            // Print the subset's index and binary representation
            System.out.print(i + ":" + binaryString + ":");

            boolean isEmpty = true;

            for (int j = 0; j < n; j++) {

                if ((i & (1 << (n - j - 1))) > 0) {
                    if (!isEmpty) {
                        System.out.print(" ");
                    }
                    System.out.print(elements[j]);
                    isEmpty = false; // Set false as subset is not empty
                }
            }

            if (isEmpty) {
                System.out.println("EMPTY");
            } else {
                System.out.println();
            }
        }

        scanner.close();
    }
}
