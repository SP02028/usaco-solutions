import java.io.*;
import java.util.*;

public class AP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[][] grid = new char[2][n];
            boolean[][] visited = new boolean[2][n];

            grid[0] = br.readLine().toCharArray();
            grid[1] = br.readLine().toCharArray();

            if (dfs(0, 0, grid, visited, n)) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }

        pw.flush();
        br.close();
        pw.close();
    }

    private static boolean dfs(int row, int col, char[][] grid, boolean[][] visited, int n) {
        if (row == 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;
        int[] dRow = {0, 0, 1, -1}; // Right, Left, Down, Up
        int[] dCol = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (isValid(newRow, newCol, n) && !visited[newRow][newCol]) {
                int finalRow = newRow;
                int finalCol = newCol;

                if (grid[newRow][newCol] == '>') {
                    finalCol++;
                } else if (grid[newRow][newCol] == '<') {
                    finalCol--;
                }

                if (isValid(finalRow, finalCol, n) && !visited[finalRow][finalCol]) {
                    if (dfs(finalRow, finalCol, grid, visited, n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int n) {
        return row >= 0 && row < 2 && col >= 0 && col < n;
    }
}

