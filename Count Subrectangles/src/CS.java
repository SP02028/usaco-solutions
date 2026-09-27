import java.util.*;
import java.io.*;
public class CS {
public static void main(String[] args) {
    Kattio kattio = new Kattio();
    int n =kattio.nextInt();
    int m = kattio.nextInt();
    int k = kattio.nextInt();
    int[][] grid = new int[n][m];
    int[] a = new int[n];
    int[] b = new int[m];
    for (int i = 0; i < n; i++) {
        a[i] = kattio.nextInt();
    }
    for (int i = 0; i < m; i++) {
        b[i] = kattio.nextInt();
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            grid[i][j] = a[i]*b[j];
        }
    }
    int[][] pre = new int[n+1][m+1];
    for (int i = 1; i <=n ; i++) {
        for (int j = 1; j <=m ; j++) {
            pre[i][j] = (a[i-1] * b[j-1]) + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
        }
    }
    long count = 0;
    for (int l = 1; l <=n ; l++) {
        if(k%l==0) {
            int w = k / l;
            if (w <= m){
                for (int i = 0; i <=n-l; i++) {
                    for (int j = 0; j <=m-w; j++) {
                        int r2 = i+l-1;
                        int c2 = j+w-1;

                        int sum = pre[r2+1][c2+1] - pre[i][c2+1] - pre[r2+1][j] + pre[i][j];
                        if(sum==k) count++;
                    }
                }
            }
        }
    }
    kattio.println(count);
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
