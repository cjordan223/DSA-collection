/*
 * Title: Main_hw3_3.java
 * Abstract:  Reads a graph's adjacency list and performs a depth-first search to mark the visiting order of its nodes, starting from the first node
 * Name: Conner Jordan  
 * Date: 1-23-2024
 */

 import java.util.*;

class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<LinkedList<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
                adj.add(new LinkedList<>());

            for (int i = 0; i < m; i++) {
                int u, v;
                u = sc.nextInt();
                v = sc.nextInt();
                adj.get(u).add(v);
            }
            ArrayList<Integer> Mark = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
                Mark.add(0);

            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            int counter = 1;
            while (!stack.empty()) {

                int cur = stack.peek();
                stack.pop();

                if (Mark.get(cur) == 0) {
                    Mark.set(cur, counter);
                    counter++;
                }

                Iterator<Integer> itr = adj.get(cur).descendingIterator();

                while (itr.hasNext()) {
                    int v = itr.next();
                    if (Mark.get(v) == 0)
                        stack.push(v);
                }

            }
            for (int i = 0; i < n; i++) {
                System.out.println("Mark[" + i + "]:" + Mark.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}