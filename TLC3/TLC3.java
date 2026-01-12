/**
 * Problem: The Lazy Cow (Silver)
 * 
 * This solution finds the maximum amount of grass a lazy cow can eat
 * without moving more than K steps. The field is rotated 45 degrees
 * to convert Manhattan distance into Chebyshev distance.
 * 
 * Approach:
 * - Rotate the field 45 degrees by transforming coordinates (i,j) -> (i+j, n-i+j-1)
 * - This converts the Manhattan distance constraint into a square region
 * - Use 2D prefix sums to efficiently calculate sum of any rectangular region
 * - For each valid cow position, calculate the sum of grass within K steps
 * 
 * Time Complexity: O(N^2) where N is field size
 * Space Complexity: O(N^2) for the rotated field and prefix sum array
 */
import java.util.*;
import java.io.*;

public class TLC3 {
    /**
     * Main method that finds the maximum grass a lazy cow can eat.
     */
    public static void main(String[] args) throws IOException {
        Kattio kattio = new Kattio("lazy");
        int n = kattio.nextInt();
        int k = kattio.nextInt();

        // Rotate field 45 degrees: new side length is 2*n-1
        int N = 2 * n - 1;
        int[][] field = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(field[i], -1);
        }

        // Read and transform coordinates
        // Rotate field 45 degrees: transform (i,j) -> (i+j, n-i+j-1)
        // This converts Manhattan distance (|x1-x2| + |y1-y2|) into Chebyshev distance (max(|x1-x2|, |y1-y2|))
        // After rotation, all cells within K steps form a square region instead of a diamond
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i + j][n - i + j - 1] = kattio.nextInt();
            }
        }

        // Build 2D prefix sum array
        int[][] prefix = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = Math.max(field[i][j], 0); // Treat -1 as 0
                prefix[i + 1][j + 1] = val + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];
            }
        }

        // Find maximum grass reachable from any position
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] == -1)
                    continue; // Skip invalid positions

                // Calculate rectangle bounds within K steps
                int sr = Math.max(i - k, 0);
                int sc = Math.max(j - k, 0);
                int er = Math.min(i + k, N - 1);
                int ec = Math.min(j + k, N - 1);

                // Calculate sum using prefix array
                int sum = prefix[er + 1][ec + 1] - prefix[er + 1][sc] - prefix[sr][ec + 1] + prefix[sr][sc];
                max = Math.max(max, sum);
            }
        }

        kattio.println(max);
        kattio.close();
    }

    /**
     * Custom I/O class for competitive programming.
     * Extends PrintWriter for output and uses BufferedReader for fast input.
     */
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input/output
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input/output
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
