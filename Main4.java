 /*
 * Title: Main_hw5_3.java
 * Abstract: Simple java program to simulate the operations of linear probing
 * Name: Conner Jordan
 * Date: 2-13-24
 */

import java.util.Scanner;

public class Main {
    static int[] hashTable;
    static int tableSize;
    static int elementCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tableSize = scanner.nextInt();
        hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1;  
        }

        int commandsCount = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "insert":
                    insert(Integer.parseInt(parts[1]));
                    break;
                case "displayStatus":
                    displayStatus(Integer.parseInt(parts[1]));
                    break;
                case "tableSize":
                    System.out.println(tableSize);
                    break;
                case "search":
                    search(Integer.parseInt(parts[1]));
                    break;
            }
        }
        scanner.close();
    }

    private static void insert(int key) {
        if (elementCount >= tableSize / 2) {
            rehash();
        }

        int index = key % tableSize;
        while (hashTable[index] != -1) {
            index = (index + 1) % tableSize;  
        }
        hashTable[index] = key;
        elementCount++;
    }

    private static void displayStatus(int index) {
        if (hashTable[index] == -1) {
            System.out.println("Empty");
        } else {
            System.out.println(hashTable[index]);
        }
    }

    private static void search(int key) {
        for (int i = 0; i < tableSize; i++) {
            int index = (key % tableSize + i) % tableSize;
            if (hashTable[index] == key) {
                System.out.println(key + " Found");
                return;
            } else if (hashTable[index] == -1) {
                break;  
            }
        }
        System.out.println(key + " Not found");
    }

    private static void rehash() {
        int oldSize = tableSize;
        tableSize = getNextPrime(tableSize * 2);
        int[] oldHashTable = hashTable;
        hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1;  
        }
        elementCount = 0;  

        for (int i = 0; i < oldSize; i++) {
            if (oldHashTable[i] != -1) {
                insert(oldHashTable[i]);  
            }
        }
    }

    private static int getNextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
