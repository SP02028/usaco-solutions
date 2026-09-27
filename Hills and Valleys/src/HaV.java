
import java.util.*;
import java.io.*;

public class HaV {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while (t-- > 0) {
            int n = io.nextInt(), a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans += check(i, n, a);
            }
            int finalans = ans;
            for (int i = 1; i < n - 1; i++) {
                int tans = ans;
                int x = a[i];
                tans -= check(i - 1, n, a) + check(i, n, a) + check(i + 1, n, a);
                a[i] = Math.min(a[i - 1], a[i + 1]);
                tans += check(i - 1, n, a) + check(i, n, a) + check(i + 1, n, a);
                finalans = Math.min(finalans, tans);
                tans -= check(i - 1, n, a) + check(i, n, a) + check(i + 1, n, a);
                a[i] = Math.max(a[i - 1], a[i + 1]);
                tans += check(i - 1, n, a) + check(i, n, a) + check(i + 1, n, a);
                finalans = Math.min(finalans, tans);
                a[i] = x;
            }
            io.println(finalans);
        }
        io.close();
    }

    public static int check(int i, int n, int a[]) {
        if (i - 1 >= 0 && i + 1 < n && ((a[i] > a[i + 1] && a[i] > a[i - 1]) || (a[i] < a[i + 1] && a[i] < a[i - 1]))) {
            return 1;
        }
        return 0;
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input/output
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input/output
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}