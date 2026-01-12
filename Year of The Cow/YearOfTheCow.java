/**
 * Problem: Year of The Cow
 * 
 * This solution finds the minimum time Bessie needs to transport N cows
 * using a spaceship that can make K trips and transport cows in groups
 * based on their birth years.
 * 
 * Approach:
 * - Convert birth years to equivalent years (ceiling division by 12)
 * - Sort cow positions and calculate gaps between consecutive cows
 * - Use K trips to cover all cows, minimizing total distance
 * - Greedily skip the K-1 largest gaps (these become separate trips)
 * - Total distance is from origin to furthest cow minus skipped gaps
 * 
 * Time Complexity: O(N log N) for sorting
 * Space Complexity: O(N) for storing positions
 */
import java.util.*;
import java.io.*;

public class YC {

    /**
     * Main method that calculates minimum transportation time.
     */
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int k = io.nextInt();

        TreeSet<Integer> s = new TreeSet<>();
        ArrayList<Integer> dist = new ArrayList<>();

        // Read cow positions and normalize to years
        for (int i = 0; i < n; i++) {
            int val = io.nextInt();
            s.add((val + 11) / 12); // Ceiling division
        }

        // Start with distance to furthest cow
        long ans = s.last();
        int lst = 0;

        // Calculate gaps between consecutive cow positions
        while (!s.isEmpty()) {
            int sm = s.first();
            dist.add(sm - lst - 1); // Gap size
            lst = sm;
            s.pollFirst();
        }

        // Sort gaps in descending order
        dist.sort(Collections.reverseOrder());

        // Skip the K-1 largest gaps (these become separate trips)
        for (int i = 0; i < k - 1 && i < dist.size(); i++) {
            ans -= dist.get(i);
        }

        // Convert back to original scale
        io.println(ans * 12);
        io.flush();
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
