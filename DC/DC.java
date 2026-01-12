/**
 * Problem: Diamond Collector
 * 
 * This solution finds the maximum number of diamonds that can be collected
 * using two display cases, where each case can hold diamonds with size difference <= K.
 * 
 * Approach:
 * - Sort diamonds by size
 * - Use two pointers to find the maximum number of diamonds in one contiguous group
 * - For each starting position, compute the best second group that doesn't overlap
 * - Use suffix maximum array to efficiently find best non-overlapping second group
 * 
 * Time Complexity: O(N log N) for sorting + O(N) for two pointers
 * Space Complexity: O(N)
 */
import java.util.*;
import java.io.*;

public class DC {
    /**
     * Main method that reads diamond sizes and computes maximum displayable diamonds.
     */
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("diamond");
        int N = io.nextInt();
        int K = io.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = io.nextInt();

        // Sort diamonds by size for two-pointer technique
        Arrays.sort(arr);
        int[] len = new int[N];
        int right = 0;

        // For each starting position, find how many diamonds fit in one case
        for (int left = 0; left < N; left++) {
            while (right < N && arr[right] - arr[left] <= K) {
                right++;
            }
            len[left] = right - left;
        }

        // maxs[i] = maximum diamonds we can get starting from index i or later
        int[] maxs = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i + 1], len[i]);
        }

        // Find best combination of two non-overlapping groups
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int j = i + len[i]; // End of first group
            ans = Math.max(ans, len[i] + maxs[j]);
        }

        io.println(ans);
        io.close();
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
