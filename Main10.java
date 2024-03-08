/*
 * Title: Main_hw3_2.java
 * Abstract: Program to solve the TSP for user-provided vertices, edges and starting point
 * Name: Conner Jordan  
 * Date: 1-23-2024
 */

import java.util.*;

public class Main {

    public static void travelingSalesmanProblem(int[][] graph, int s) {
        List<Integer> vertex = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (i != s) {
                vertex.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>(vertex);

        int minPath = Integer.MAX_VALUE;
        do {
            int currentPathWeight = 0;
            int k = s;
            for (int i = 0; i < vertex.size(); i++) {
                if (graph[k][vertex.get(i)] == Integer.MAX_VALUE) {
                    currentPathWeight = Integer.MAX_VALUE;
                    break;
                } else {
                    currentPathWeight += graph[k][vertex.get(i)];
                    k = vertex.get(i);
                }
            }
            if (currentPathWeight < Integer.MAX_VALUE) {
                currentPathWeight += graph[k][s];
            }

            if (currentPathWeight < minPath) {
                ans = new ArrayList<>(vertex);
                minPath = currentPathWeight;
            }

        } while (nextPermutation(vertex));

        if (minPath < Integer.MAX_VALUE && minPath >= 0) {
            System.out.print("Path:" + s);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("->" + ans.get(i));
            }
            System.out.println("->" + s);
            System.out.println("Cost:" + minPath);
        } else {
            System.out.println("Path:");
            System.out.println("Cost:-1");
        }

    }

    private static boolean nextPermutation(List<Integer> array) {
        int i = array.size() - 2;
        while (i >= 0 && array.get(i) >= array.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = array.size() - 1;
        while (array.get(j) <= array.get(i)) {
            j--;
        }

        Collections.swap(array, i, j);
        Collections.reverse(array.subList(i + 1, array.size()));
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int cost = scanner.nextInt();
            graph[u][v] = cost;
        }

        int source = scanner.nextInt();
        travelingSalesmanProblem(graph, source);
    }
}
