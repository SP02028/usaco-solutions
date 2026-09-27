import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class PP {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T= kattio.nextInt();
        while(T-->0){
            int n = kattio.nextInt();
            int m = kattio.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = kattio.nextInt();
                }
            }
            int ans = 0;
            int maxDist = n + m - 2;
            
            for (int d = 0; d < (maxDist + 1) / 2; d++) {
                int ct1 = 0;
                int ct0 = 0;
                for (int i = 0; i <= d; i++) {
                    int j = d - i;
                    if (i < n && j < m) {
                        if (grid[i][j] == 0) ct0++;
                        else ct1++;
                    }
                }
                int oppositeDist = maxDist - d;
                if (oppositeDist != d) {
                    for (int i = 0; i < n; i++) {
                        int j = oppositeDist - i;
                        if (j >= 0 && j < m) {
                            if (grid[i][j] == 0) ct0++;
                            else ct1++;
                        }
                    }
                }
                
                ans += Math.min(ct1, ct0);
            }
            kattio.println(ans);
        }
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
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
