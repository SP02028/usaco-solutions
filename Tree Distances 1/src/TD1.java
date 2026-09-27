import java.util.*;
import java.io.*;
public class TD1 {
    static HashMap<Integer, List<Integer>> adj = new HashMap<>();
    static int[] furthest;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int n = kattio.nextInt();
        for (int i = 0; i < n-1; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            adj.computeIfAbsent(a, k-> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
        }
        // calculate initial diameter
        furthest= new int[2];
        dfs(0,-1,0);
        dfs(furthest[0],-1,0 );
        int diameter = furthest[1];
        //calculate distances from e1
        int[] dists1 = new int[n];
        int start = furthest[0];
        furthest=new int[2];
        distances(start, -1,0,dists1);
        //calculate distances from e2
        int[] dists2 = new int[n];
        distances(furthest[0], -1,0,dists2);

        //find distances from each node
        int[] dists = new int[n];
        for (int i = 0; i < n; i++) {
            dists[i] = Math.max(dists1[i], dists2[i]);
        }
        for(int ele: dists){
            kattio.print(ele + " ");
        }
        kattio.close();
    }
    static void dfs(int node, int parent, int dist){
        if(dist> furthest[1]){
            furthest[0] = node;
            furthest[1] = dist;
        }
        for(int nbr: adj.get(node)){
            if(nbr != parent){
                dfs(nbr, node, dist+1);
            }
        }
    }
    static void distances(int u, int p, int d, int[] dists) {
        dists[u] = d;
        if (d > furthest[1]) {
            furthest[1] = d;
            furthest[0] = u;
        }
        if (adj.get(u) == null) return;
        for (int v : adj.get(u)) {
            if (v != p) {
                distances(v, u, d + 1, dists);
            }
        }
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
