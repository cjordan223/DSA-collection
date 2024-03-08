/*
 * Title: Main_hw6_2.java
 * Abstract: Program to implement Floyd's Algorithm to display all-pairs shortest paths. 
 * Name: Conner Jordan
 * Date: 2-16-24
 */

import java.util.Scanner;

public class Main {

    final static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                int value = scanner.nextInt();
                graph[i][j] = (value == -1) ? INF : value;
            }
        }

        floydWarshall(graph, vertices);
    }

    public static void floydWarshall(int[][] graph, int vertices) {
        int[][] dist = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, vertices);
    }

    public static void printSolution(int[][] dist, int vertices) {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (j > 0)
                    System.out.print(" ");
                if (dist[i][j] >= INF / 2) {
                    System.out.print("-1");
                } else {
                    System.out.print(dist[i][j]);
                }
            }
            System.out.println();
        }
    }
}
