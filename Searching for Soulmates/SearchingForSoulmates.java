/**
 * Problem: Searching for Soulmates
 * 
 * This solution finds the minimum number of operations to transform number a into number b.
 * Operations allowed: +1, divide by 2 (if even), multiply by 2.

 * Time Complexity: O(log max(a,b)) recursive depth
 * Space Complexity: O(log max(a,b)) for recursion stack
 */
import java.util.*;
import java.io.*;

public class SfS {
    /**
     * Main method that processes test cases.
     */
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        for (int i = 0; i < N; i++) {
            long a = kattio.nextLong();
            long b = kattio.nextLong();
            kattio.println(solve(a, b));
        }
        kattio.close();
    }

    /**
     * Recursively find minimum operations to transform a into b.
     * 
     * @param a starting number
     * @param b target number
     * @return minimum number of operations
     */
    public static long solve(long a, long b) {
        if (a == b) {
            return 0;
        } else if (a > b) {
            // When a > b, we can only decrease a
            // Make a even (if odd, +1) then divide by 2
            long odd = a % 2;
            return 1 + odd + solve((a + odd) / 2, b);
        } else {
            // When a < b, try two strategies:
            // 1. Add (b-a) directly
            // 2. Make b smaller by dividing by 2, then solve
            long odd = b % 2;
            return Math.min(b - a, 1 + odd + solve(a, b / 2));
        }
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
