import java.util.*;
import java.io.*;
public class TLC3 {
    //the lazy cow, silver
    public static void main(String[] args) throws IOException{
        Kattio kattio =new Kattio("lazy");
        int n = kattio.nextInt();
        int k = kattio.nextInt();

        int N = 2*n-1; //new side length cause of rotation
        int[][] field = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(field[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i+j][n-i+j-1] = kattio.nextInt(); //what? why this position?
            }
        }
        int[][] prefix = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = Math.max(field[i][j],0);
                prefix[i+1][j+1] = val + prefix[i+1][j] + prefix[i][j+1]-prefix[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(field[i][j] == -1) continue;
                int sr = Math.max(i-k,0);
                int sc = Math.max(j-k,0);
                int er = Math.min(i+k, N-1);
                int ec = Math.min(j+k, N-1);
                max = Math.max(max ,  prefix[er+1][ec+1]-prefix[er+1][sc]-prefix[sr][ec+1]+prefix[sr][sc]);
            }
        }
        kattio.println(max);
        kattio.close();
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
