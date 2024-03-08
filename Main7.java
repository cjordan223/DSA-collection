// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw4_3.java
 * Abstract: Topological sorting based on the Kahn algorithm.
 * Name: Conner Jordan
 * Date: 02-04-24
 */

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int V = scanner.nextInt();
    int E = scanner.nextInt();

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();
      adj.get(u).add(v);
    }

    topoSort(V, adj);
  }

  public static void topoSort(int V, List<List<Integer>> adj) {
    int[] indegree = new int[V];
    for (int i = 0; i < V; i++) {
      for (int node : adj.get(i)) {
        indegree[node]++;
      }
    }

    for (int i = 0; i < V; i++) {
      System.out.println("In-degree[" + i + "]:" + indegree[i]);
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int cnt = 0;
    List<Integer> order = new ArrayList<>();
    while (!q.isEmpty()) {
      int u = q.poll();
      order.add(u);

      for (int node : adj.get(u)) {
        if (--indegree[node] == 0) {
          q.add(node);
        }
      }
      cnt++;
    }

    if (cnt != V) {
      System.out.println("No Order:");
    } else {
      System.out.print("Order:");
      for (int i = 0; i < order.size(); i++) {
        System.out.print(order.get(i));
        if (i < order.size() - 1) {
          System.out.print("->");
        }
      }
      System.out.println();
    }
  }
}
