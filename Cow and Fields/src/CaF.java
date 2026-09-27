import java.io.*;
import java.util.*;

public class CaF {
    static List<Integer>[] adj;
    static int[] distssn;
    static int[] distsnv;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        int K = kattio.nextInt();
        int[] special = new int[K];
        for (int i = 0; i < K; i++) {
            special[i] = kattio.nextInt();
        }
        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        //bfs shortest path s-> each node
        distssn= new int[N+1];
        distsnv = new int[N+1];
        int S = 1;
        int V = N;
        bfs(S, distssn);
        //bfs shortest path each node -> v
        bfs(V, distsnv);
        // Original shortest path from 1 to N (without any new edge)
        int ogdist = distssn[N];

        long max = -1;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                if(i == j) continue;
                long path = distssn[special[i]] + 1 + distsnv[special[j]];
                max = Math.max(max, path);
            }
        }
        long result = Math.min(ogdist, max);
        kattio.println(result);
        kattio.close();
    }
    //lets see what we remember from bfs shortest path
    static void bfs(int S, int[] dist)
    {
        Queue<Integer> q = new LinkedList<>();
        // Initialize all distances to "infinity"
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        // Push the source node to the queue
        q.add(S);

        // Iterate until the queue is not empty
        while (!q.isEmpty()) {
            // Pop the node at the front of the queue
            int node = q.poll();

            // Explore all the neighbors of the current node
            for (int neighbor : adj[node]) {
                // Check if the neighboring node is not
                // visited
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    // Mark the distance of the neighboring
                    // node as the distance of the current
                    // node + 1
                    dist[neighbor] = dist[node] + 1;
                    // Insert the neighboring node to the
                    // queue
                    q.add(neighbor);
                }
            }
        }
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public long nextLong() {
            // TODO Auto-generated method stub
            return Long.parseLong(next())	;	}
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}
