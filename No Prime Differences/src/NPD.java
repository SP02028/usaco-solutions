import java.io.*;
import java.util.*;

public class NPD {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = io.nextInt();
            int m = io.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i % 2 == 0) {
                        io.print((n / 2 + i / 2) * m + j + 1 + " ");
                    } else {
                        io.print((i / 2) * m + j + 1 + " ");
                    }
                }
                io.println();
            }
        }
        io.close();
    }

    // Standard Kattio template
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
                try {
                    st = new StringTokenizer(r.readLine());
                } catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
