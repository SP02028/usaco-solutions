/**
 * Problem: Moocast
 * 
 * This solution determines the maximum number of cows that can hear
 * a broadcast from any single cow, given their positions and transmission powers.
 * 
 * Approach:
 * - Build a directed graph where an edge exists from cow A to cow B if
 *   the distance between them is within cow A's transmission power
 * - For each cow, perform DFS to count how many cows can be reached
 * - Return the maximum count across all starting cows
 * 
 * Time Complexity: O(N^3) where N is the number of cows
 * Space Complexity: O(N^2) for the adjacency list
 */
import java.util.*;
import java.io.*;

public class M {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int count = 1;

    /**
     * Main method that reads cow positions and computes maximum broadcast reach.
     */
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("moocast");
        int N = io.nextInt();
        int[][] cows = new int[N][2];
        int[] powers = new int[N];
        visited = new boolean[N];
        adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Read cow positions and transmission powers
        for (int i = 0; i < N; i++) {
            int x = io.nextInt();
            int y = io.nextInt();
            int p = io.nextInt();
            powers[i] = p;
            cows[i][0] = x;
            cows[i][1] = y;
        }

        // Build directed graph: edge from i to j if cow i can reach cow j
        for (int i = 0; i < N; i++) {
            double power = powers[i];
            for (int j = 0; j < N; j++) {
                if (dist(cows[i][0], cows[i][1], cows[j][0], cows[j][1]) <= power) {
                    adj.get(i).add(j);
                }
            }
        }

        // Try starting broadcast from each cow
        int maxcount = -1;
        for (int i = 0; i < N; i++) {
            dfs(i);
            maxcount = Math.max(maxcount, count);
            Arrays.fill(visited, false);
            count = 1;
        }

        io.println(maxcount);
        io.close();
    }

    /**
     * Depth-first search to count reachable cows from a starting cow.
     * 
     * @param s the starting cow index
     */
    public static void dfs(int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        for (int nbr : adj.get(s)) {
            if (!visited[nbr]) {
                count++;
                dfs(nbr);
            }
        }
    }

    /**
     * Calculate Euclidean distance between two points.
     * 
     * @return the distance between (x1, y1) and (x2, y2)
     */
    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
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
