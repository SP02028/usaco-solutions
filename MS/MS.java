import java.util.*;
import java.io.*;
public class MS {
    /**
     * The main method is the entry point of the program. It processes input
     * data, performs computations such as sorting and prefix sum calculations,
     * and handles queries to update and retrieve data based on problem logic.
     *
     * @param args the command-line arguments passed to the program
     */
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long[] a = new long[N+1];
        Integer[] indices = new Integer[N];
        for (int i = 1; i <= N; i++) {
            a[i] = kattio.nextLong();
            indices[i-1] = i;
        }

        Arrays.sort(indices, (i1, i2) -> Long.compare(a[i1], a[i2]));

        int[] pos = new int[N+1];
        long[] sorted = new long[N+1];
        for (int i = 1; i <= N; i++) {
            int og = indices[i-1];
            sorted[i] = a[og];
            pos[og] = i;
        }

        long[] pref = new long[N+1];
        long T = 0;
        for (int i = 1; i <= N; i++) {
            pref[i] = sorted[i] + pref[i-1];
            T += (long) i * sorted[i];
        }

        int Q = kattio.nextInt();
        for (int i = 0; i < Q; i++) {
            int j = kattio.nextInt();
            long aj = kattio.nextLong();

            int oldp = pos[j];
            long oldv = a[j];

            int newpos = Arrays.binarySearch(sorted, 1, N + 1, aj);
            if (newpos < 0) {
                newpos = -(newpos + 1);
            }

            long curr = T;
            if (aj >= oldv) {
                newpos--;
                long sumnum = pref[newpos] - pref[oldp];
                curr = T - (long) oldp * oldv - sumnum + (long) newpos * aj;
            } else {
                long sumnum = pref[oldp - 1] - pref[newpos - 1];
                curr = T - (long) oldp * oldv + sumnum + (long) newpos * aj;
            }
            kattio.println(curr);
        }
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
