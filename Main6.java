 /*
 * Title: Main_hw5_1.java
 * Abstract: Simple java program to conduct heap operations
 * Name: Conner Jordan
 * Date: 2-13-24
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
      
        int[] heap = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      
        if (!isMaxHeap(heap, n)) {
          
            System.out.println("This is NOT a heap.");
            buildMaxHeap(heap, n);
        } else {
          
            System.out.println("This is a heap.");
        }

        int commandsCount = Integer.parseInt(scanner.nextLine());
      
        for (int i = 0; i < commandsCount; i++) {
          
            String command = scanner.nextLine();
            if ("displayMax".equals(command)) {
                System.out.println(heap[0]);
              
            } else if (command.startsWith("insert")) {
              
                int value = Integer.parseInt(command.split(" ")[1]);
                heap = Arrays.copyOf(heap, heap.length + 1);
                heap[heap.length - 1] = value;
                maxHeapInsert(heap, heap.length);
              
            } else if ("deleteMax".equals(command)) {
              
                heap[0] = heap[heap.length - 1];
                heap = Arrays.copyOf(heap, heap.length - 1);
                maxHeapify(heap, 0, heap.length);
              
            } else if ("display".equals(command)) {
              
                displayHeap(heap);
              
            }
        }
        scanner.close();
    }

    private static boolean isMaxHeap(int[] heap, int n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (heap[i] < heap[2 * i + 1] || (2 * i + 2 < n && heap[i] < heap[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    private static void buildMaxHeap(int[] heap, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i, n);
        }
    }

    private static void maxHeapify(int[] heap, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < n && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;

            maxHeapify(heap, largest, n);
        }
    }

    private static void maxHeapInsert(int[] heap, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i, n);
        }
    }

  private static void displayHeap(int[] heap) {
      if (heap.length > 0) {
          System.out.print(heap[0]);   
          for (int i = 1; i < heap.length; i++) {
              System.out.print(" " + heap[i]);   
          }
      }
      System.out.println();   
  }

}
