import java.io.*;
import java.util.*;

public class GWM {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();

        while (t-- > 0) {
            int n = io.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = io.nextInt();
            for (int i = 0; i < n; i++) b[i] = io.nextInt();

            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; i++) ids[i] = i;

            Arrays.sort(ids, (i, j) -> Integer.compare(a[j] + b[j], a[i] + b[i]));

            long S = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) { 
                    S += a[ids[i]] - 1;
                } else {         
                    S -= b[ids[i]] - 1;
                }
            }

            io.println(S);
        }
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(r.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
