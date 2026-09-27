import java.util.*;
import java.io.*;

public class BiC {
    static long[] storedans;

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
       // int[] parent = new int[N];
    //   parent[0] = -1;
        List<Integer>[] parents = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            parents[i] = new ArrayList<>();
        }

        // Input format: for nodes 1..N-1, read parent (1-indexed in input)
        for (int child = 1; child < N; child++) {
            int p = kattio.nextInt() - 1; // parent, 0-indexed
            parents[p].add(child);
        }

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = kattio.nextInt();
        }
        storedans = new long[N];
        //todo figure out how to traverse so that the whole tree is effectively simulated
        //ok so the idea is basically to work our way up from the bottom and calcualte ceil(sum nodes/#leaves)
        //and then store that in the top most node. And then the max ans is the anser
        //find bottommost parents, calculate, store, repeat.
        //postorder dfs?
        dfs(0,parents, weights);
        long max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(storedans[i],max );
        }
        kattio.println(max);
        kattio.close();
    }
    public static long[] dfs(int u, List<Integer>[] adj, int[] weights) {
        long currsum = weights[u];
        long currnodes = 1;
        long currleaves = 0;

        for (int v : adj[u]) {
            long[] childdata = dfs(v, adj, weights);
            currsum += childdata[0];
            currnodes += childdata[1];
            currleaves += childdata[2];
        }

        if (adj[u].isEmpty()) currleaves = 1;

        // ceil(currsum / currleaves)
        storedans[u] = (currsum + currleaves - 1) / currleaves;

        return new long[]{currsum, currnodes, currleaves};
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
