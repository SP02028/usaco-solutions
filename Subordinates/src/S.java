import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;
public class S {
    public static List<Integer>[] adj;
    public static int[] sizes;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int[] parents = new int[N];
        parents[0] = -1;
        for (int i = 1; i < N; i++) {
            parents[i] = io.nextInt()-1;
        }
        adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        buildAdjacencyList(parents, N);
        sizes = new int[N];
        calcsize(0,-1);
        for (int i = 0; i < N; i++) {
            io.print( sizes[i]-1+ " ");
        }
        io.close();
    }
    public static int calcsize(int node, int parent){
        int curr =1 ;
        for(int child: adj[node]){
            if(child != parent){
                curr += calcsize(child, node);
            }
        }
        sizes[node] = curr;
        return curr;
    }
    public static void buildAdjacencyList(int[] parent, int N) {
        for (int i = 0; i < N; i++) {
            int p = parent[i];
            if (p != -1) {
                adj[i].add(p);
                adj[p].add(i);
            }
        }
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
