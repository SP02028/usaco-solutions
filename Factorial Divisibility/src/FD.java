import java.io.*;
import java.util.*;
public class FD {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int X = kattio.nextInt();
        int[] arr = new int[N];
        int[] c = new int[X+1];
        for (int i = 0; i < N; i++) {
            arr[i] = kattio.nextInt();
            c[arr[i]]++;
        }

        boolean possible = true;
        for (int i = 0; i < X; i++) {
            int count = c[i];
            int mod = c[i] % (i + 1);

            c[i+1] += c[i]/(i+1);
            c[i] = mod;
        }
        for (int i = 0; i < X; i++) {
            if(c[i] > 0) {
                possible=false;
                break;
            }
        }
        if (possible) kattio.println("YES");
        else kattio.println("NO");
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
