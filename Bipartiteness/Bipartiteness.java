/**
 * Problem: Bipartiteness
 * 
 * This solution determines if a tree can be colored using two colors (bipartite)
 * and calculates the number of edges that can be added between differently colored nodes.
 * 
 * Approach:
 * - Use DFS to color nodes alternately (1 and 2)
 * - Count nodes of each color
 * - Answer is (red-1) * (blue-1) since we already have N-1 edges in the tree
 */
import java.io.*;
import java.util.*;

public class B {
    static List<List<Long>> adj = new ArrayList<>();
    static boolean[] visited;
    static long[] colors;

    /**
     * Main method that reads input, colors the tree, and outputs the answer.
     */
    public static void main(String[] args) {
        Kattio io = new Kattio();
        long N = io.nextInt();
        visited = new boolean[(int) N];
        colors = new long[(int) N];

        // Initialize adjacency list for each node
        for (long i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the tree by reading edges
        for (int i = 0; i < N - 1; i++) {
            long a = io.nextInt() - 1;
            long b = io.nextInt() - 1;
            adj.get((int) a).add(b);
            adj.get((int) b).add(a);
        }

        // Start coloring from node 0 with color 1
        colors[0] = 1;
        dfs(0);

        // Count nodes by color
        long red = 0;
        long blue = 0;
        for (long i = 0; i < N; i++) {
            if (colors[(int) i] == 1) {
                red++;
            } else {
                blue++;
            }
        }

        // Calculate maximum edges that can be added between different colors
        // Subtract 1 from each count because we already have N-1 edges
        io.println((red - 1) * (blue - 1));
        io.close();
    }

    /**
     * Depth-first search to color the tree alternately.
     * Each node gets the opposite color (3 - parent_color) of its parent.
     * 
     * @param s the current node to color
     */
    static void dfs(long s) {
        for (long nbr : adj.get((int) s)) {
            if (colors[(int) nbr] == 0) {
                // Assign opposite color: if parent is 1, child is 2; if parent is 2, child is 1
                colors[(int) nbr] = 3 - colors[(int) s];
                dfs(nbr);
            }
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
