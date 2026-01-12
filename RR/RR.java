/**
 * Problem: Array Recovery (RR)
 * 
 * This solution reconstructs an array from its difference matrix.
 * Given dif[i][j] = max(a[i..i+j]) - min(a[i..i+j]), recover array a.
 * 
 * Approach:
 * - Work backwards from the end of the array
 * - At each position, try both a[i] = a[i+1] + dif[i][1] and a[i] = a[i+1] - dif[i][1]
 * - Verify that the choice satisfies all difference constraints for subarrays starting at i
 * - Use the valid choice to continue reconstruction
 * 
 * Time Complexity: O(N^2) for verification
 * Space Complexity: O(N^2) for storing the difference matrix
 */
import java.io.*;
import java.util.*;

public class RR {

    static int N;
    static int[][] dif;
    static int[] ans;

    /**
     * Main method that reconstructs the array from difference constraints.
     */
    public static void main(String[] args) {
        Kattio io = new Kattio();

        N = io.nextInt();
        dif = new int[N][N];

        // Read difference matrix: dif[i][j] = max(a[i..i+j]) - min(a[i..i+j])
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                dif[i][j] = io.nextInt();
            }
        }

        ans = new int[N];

        // Reconstruct array from right to left
        for (int i = N - 2; i >= 0; i--) {
            // Try adding the difference
            ans[i] = ans[i + 1] + dif[i][1];
            if (!ok(i)) {
                // If adding doesn't work, try subtracting
                ans[i] = ans[i + 1] - dif[i][1];
                // This is guaranteed to be valid by problem constraints
            }
        }

        // Output the reconstructed array
        for (int i = 0; i < N; i++) {
            io.print(ans[i] + (i + 1 == N ? "\n" : " "));
        }
        io.close();
    }

    /**
     * Verify that ans[i] satisfies all difference constraints for subarrays starting at i.
     * 
     * @param i the starting index to verify
     * @return true if all constraints are satisfied, false otherwise
     */
    static boolean ok(int i) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int j = i; j < N; j++) {
            mx = Math.max(mx, ans[j]);
            mn = Math.min(mn, ans[j]);
            if (mx - mn != dif[i][j - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Custom I/O class for competitive programming.
     * Extends PrintWriter for output and uses BufferedReader for fast input.
     */
    static class Kattio extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        Kattio() {
            super(new BufferedOutputStream(System.out));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
