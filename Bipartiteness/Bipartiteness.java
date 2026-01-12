import java.io.*;
import java.util.*;
public class B {
    static List<List<Long>> adj = new ArrayList<>();
    static boolean[] visited;
    static long[] colors;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        long N = io.nextInt();
        visited = new boolean[(int)N];
        colors= new long[(int)N];
        for (long i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            long a = io.nextInt()-1;
            long b = io.nextInt()-1;
            adj.get((int) a).add(b);
            adj.get((int) b).add(a);
        }
        colors[0]=1;
        dfs(0);
        long red =0;
        long blue =0;
        for(long i =0;i<N;i++){
            if(colors[(int)i]==1){
                red++;
            }else{
                blue++;
            }
        }
        io.println((red-1)*(blue-1));
        io.close();
    }
    static void dfs(long s) {
        for (long nbr : adj.get((int)s)) {
            if (colors[(int)nbr] == 0) {
                colors[(int)nbr] = 3 - colors[(int)s];
                dfs(nbr);
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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
