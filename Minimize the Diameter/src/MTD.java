import java.util.*;
import java.io.*;
public class MTD {
   static HashMap<Integer, List<Integer>> tree1 = new HashMap<>();
   static HashMap<Integer, List<Integer>> tree2 = new HashMap<>();
   static int farthest[];
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        for (int i = 0; i < N-1; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            tree1.computeIfAbsent(a, k-> new ArrayList<Integer>()).add(b);
            tree1.computeIfAbsent(b, k-> new ArrayList<Integer>()).add(a);
        }
        int M = kattio.nextInt();
        for (int i = 0; i < M-1; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            tree2.computeIfAbsent(b, k-> new ArrayList<Integer>()).add(a);
            tree2.computeIfAbsent(a, k-> new ArrayList<Integer>()).add(b);
        }
        farthest = new int[2];
        dfs(0,-1,0, tree1);
        farthest = new int[2];
        dfs(farthest[0], -1, 0,  tree1);
        int end = farthest[0];
        int size1 = farthest[1]+1;
        //diameter of tree 2 and find middle node
        farthest = new int[2];
        dfs(0,-1,0, tree2);
        farthest = new int[2];
        dfs(farthest[0], -1, 0,  tree2);
        int end2 = farthest[0];
        int size2 = farthest[1]+1;
        //find comb diameter
        int newd = Math.max(Math.ceilDiv(size1, 2)+Math.ceilDiv(size2, 2)+1, Math.max(size2, size1));
        kattio.println(newd);
        kattio.close();
    }
    static void dfs(int n, int parent, int dist, HashMap<Integer, List<Integer>> tree){
        if(dist > farthest[1]){
            farthest[0] = n;
            farthest[1] = dist;
        }
        for(int v : tree.get(n)){
            if(v!=parent){
                dfs(v,n, dist+1, tree);
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
