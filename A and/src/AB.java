import java.util.*;
import java.io.*;
public class AB {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            long a= io.nextLong();
            long b = io.nextLong();
            if(a==b){
                io.println(0);
                continue;
            }
            long k = 0;
            long diff = Math.abs(a-b);
            long sum;
            while (true) {
                sum = (long)k * (k + 1) / 2;
                if (sum >= diff && (sum % 2 == diff % 2)) {
                    break;
                }
                k++;
            }

            io.println(k);
        }
        io.close();
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
