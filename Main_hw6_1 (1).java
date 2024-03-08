
/*
 * Title: Main_hw6_1.java
 * Abstract: Program to collect max number of coins on an n x m board.
 * Name: Conner Jordan
 * Date: 2-15-24
 */

import java.util.Scanner;

public class Main {

    private static int[][] board;
    private static int[][] dp;
    private static String[][] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        board = new int[n][m];
        dp = new int[n][m];
        path = new String[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                dp[i][j] = -1;
                path[i][j] = "";
            }
        }

        collectMaxCoins(0, 0, n, m);
        System.out.println("Max coins:" + dp[0][0]);
        System.out.println("Path:" + buildPath(n, m));

        scanner.close();
    }

    private static int collectMaxCoins(int i, int j, int n, int m) {
        if (i >= n || j >= m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int right = collectMaxCoins(i, j + 1, n, m);
        int down = collectMaxCoins(i + 1, j, n, m);

        if (right > down) {
            path[i][j] = "R";
            dp[i][j] = right + board[i][j];
        } else {
            path[i][j] = "D";
            dp[i][j] = down + board[i][j];
        }

        return dp[i][j];
    }

    private static String buildPath(int n, int m) {
        StringBuilder pathBuilder = new StringBuilder();
        int i = 0, j = 0;
        pathBuilder.append("(").append(i + 1).append(",").append(j + 1).append(")");

        while (i < n - 1 || j < m - 1) {
            if (i < n - 1 && j < m - 1) {
                if (path[i][j].equals("R")) {
                    j++;
                } else {
                    i++;
                }
            } else if (i == n - 1) {
                j++;
            } else if (j == m - 1) {
                i++;
            }
            pathBuilder.append("->(").append(i + 1).append(",").append(j + 1).append(")");
        }

        return pathBuilder.toString();
    }

}
