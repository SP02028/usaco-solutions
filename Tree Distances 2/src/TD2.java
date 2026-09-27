import java.util.*;
import java.io.*;
public class TD2 {
    static HashMap<Integer, List<Integer>> tree = new HashMap<>();
    static int[] subtreesizes;
    static int[] answer;
    static int N;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        N = kattio.nextInt();
        for (int i = 0; i < N-1; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            tree.computeIfAbsent(a, k-> new ArrayList<>()).add(b);
            tree.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
        }
        subtreesizes = new int[N];
        answer = new int[N];
        dfs1(0,-1,0);
        dfs2(0,-1);
        for (int i = 0; i < N; i++) {
            kattio.print(answer[i]+" ");
        }
    kattio.close();
    }
    public static int dfs1(int node, int parent, int depth){
        int size=1;
        answer[0] += depth;
        for(int nbr: tree.get(node)){
            if(nbr!=parent){
                int childsize = dfs1(nbr, node, depth+1);
                size+=childsize;
            }
        }
        subtreesizes[node] = size;
        return size;
    }
    public static void dfs2(int node, int parent){
        for(int child: tree.get(node)){
            if(child!=parent){
                answer[child] = answer[node]+N-2*subtreesizes[child];
                dfs2(child, node);
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
