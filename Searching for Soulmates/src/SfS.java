import java.util.*;
import java.io.*;
public class SfS {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        for (int i = 0; i < N; i++) {
            long a = kattio.nextLong();
            long b = kattio.nextLong();
            kattio.println(solve(a,b));
        }
        kattio.close();
    }
    public static long solve(long a, long b){
        if(a==b) {
            return 0;
        }
        else if(a>b){
            long odd = a%2;
            return 1+odd+solve((a+odd)/2,b);
        }
        else{
            long odd = b%2;
            return Math.min(b-a, 1+odd + solve(a, b/2));
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
