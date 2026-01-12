/**
 * Problem: Closing the Farm
 * 
 * This solution determines if a farm remains connected as barns are closed one by one.
 * Uses DFS to check connectivity after each closure.
 * 
 * Approach:
 * - Build adjacency list of farm connections
 * - For each step, mark a barn as closed and check if remaining barns are connected
 * - Use DFS from any open barn to visit all reachable barns
 * - Answer is "YES" if all open barns are reachable, "NO" otherwise
 * 
 * Time Complexity: O(N^2) where N is the number of barns
 * Space Complexity: O(N + E) for adjacency list
 */
import java.io.*;
import java.util.*;

public class CTF {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static boolean[] closed;

    /**
     * Main method that reads farm layout and processes barn closures.
     */
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("closing");
        int nodes = io.nextInt();
        int edges = io.nextInt();

        // Initialize adjacency list
        adj = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++)
            adj.add(new ArrayList<>());

        // Build undirected graph
        for (int i = 0; i < edges; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        closed = new boolean[nodes];
        visited = new boolean[nodes];
        int[] closeOrder = new int[nodes];

        // Read the order in which barns will be closed
        for (int i = 0; i < nodes; i++) {
            closeOrder[i] = io.nextInt() - 1;
        }

        // Check initial connectivity with all barns open
        dfs(0);
        io.println(connected(visited));
        Arrays.fill(visited, false);

        // Process each barn closure
        for (int i = 0; i < nodes - 1; i++) {
            closed[closeOrder[i]] = true;
            // Start DFS from the next barn to be closed (which is still open)
            dfs(closeOrder[i + 1]);
            io.println(connected(visited));
            Arrays.fill(visited, false);
        }
        io.close();
    }

    /**
     * Depth-first search to visit all connected open barns.
     * 
     * @param s the starting barn for DFS
     */
    static void dfs(int s) {
        if (visited[s]) {
            return;
        }

        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u] && !closed[u]) {
                dfs(u);
            }
        }
    }

    /**
     * Check if all open barns have been visited (i.e., are connected).
     * 
     * @param visited array indicating which barns were reached by DFS
     * @return "YES" if all open barns are connected, "NO" otherwise
     */
    public static String connected(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!closed[i] && visited[i] == false) {
                return "NO";
            }
        }
        return "YES";
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

