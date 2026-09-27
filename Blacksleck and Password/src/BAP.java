import java.util.*;
import java.io.*;
public class BAP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int t = kattio.nextInt();
        while (t-- > 0) {
            int N = kattio.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = kattio.nextInt();
            }
            int[] diffs = new int[N-1];
            for (int i = 1; i < N; i++) {
                diffs[i-1] = arr[i]-arr[0];
            }
            int g = diffs[0];
            for (int i = 0; i < N-1; i++) {
                g = gcd(g, diffs[i]);
            }
            kattio.println(g);
        }
        kattio.close();
    }
    public static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
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


