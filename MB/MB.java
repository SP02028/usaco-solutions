/**
 * Problem: Moo Buzz
 * 
 * This solution finds the Nth number in a sequence that skips multiples of 3 and 5.
 * The sequence is: 1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22, ...
 * 
 * Approach:
 * - Observe that in every 15 consecutive numbers, exactly 8 are not multiples of 3 or 5
 * - The pattern within each group of 15 is: [1, 2, 4, 7, 8, 11, 13, 14]
 * - Calculate which cycle we're in and which position within that cycle
 * - Map the position to the actual number using the pattern
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
import java.util.*;
import java.io.*;

public class MB {

    /**
     * Main method that finds the Nth number not divisible by 3 or 5.
     */
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("moobuzz");
        long target = io.nextInt();

        // Each cycle of 15 numbers contains 8 valid numbers
        long cycles = (target - 1) / 8;
        long remainder = (target - 1) % 8;
        long result = cycles * 15;

        // Pattern of valid numbers within each cycle of 15
        int[] pattern = {1, 2, 4, 7, 8, 11, 13, 14};
        result += pattern[(int) remainder];

        io.println(result);
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
